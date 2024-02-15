# Authentication Process
## Auth-token generation for a login session
![image](https://github.com/learning-project-01/bookstore-app/assets/130679461/b2c06cc4-e2a9-40f2-afa8-36695d9f4488)  

When a user sings-up and logs in using the same credentials then token and its type is returned as an response.
```java
 @PostMapping("/login")
  public Token authenticate(@RequestBody User user){
    String tokenValue = userService.authenticate(user);
    Token token = new Token();
    token.setEncodedTokenValue(tokenValue);
    return token;
  }
```
This will return a token with `setEncodedTokenValue()` which sets its type and value. Its values is generated when `userService.authenticate(user)` is executed successfully.
## When the user sends request after logging in
![image](https://github.com/learning-project-01/bookstore-app/assets/130679461/f3b85b8d-9ae8-4139-bcb7-f7dd5d2ff82f)  
```java
 public String createAuthenticationContext(User user) {
    AuthenticationContext context = new AuthenticationContext();
    context.setUser(user);
    context.setUserId(user.getEmail());
    context.setHeaderTokenUUID(UUID.randomUUID().toString());
    context.setExpiryAt(authTokenTtl * 60 * 1000 + System.currentTimeMillis());
    authCacheClient.put(context.getUserId(), context);
    authCacheClient.put(context.getHeaderTokenUUID(), context);
    return AppUtils.getEncodedString(context.getHeaderTokenUUID());
  }
```
- A AuthenticationContext is generated we login and all the properties of the context is set.
- Then the context is stored in the AuthCacheClient in a concurrent-hashmap named `tokenMap`
- When we send a request it first goes to the servlet container in our case it is Tomcat which is embedded in spring boot.  
- Then it gets forwarded to the filter not the controller, since the filters are mostly configured for the application we have configured our for all urls `registrationBean.addUrlPatterns("/*");`. In our case the filter 
checks if request uri is public or not. It matches the request with our predefined array of allowed patterns which is stored in `PUBLIC_URI_PATTERNS`,  If its public then it dosen't require any special requirement and is forwarded to the controller for further processing.
```java
@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
HttpServletRequest request = (HttpServletRequest) servletRequest;
log.info("filter executed for url: {}", request.getRequestURL());
log.info("filter executed for uri: {}", request.getRequestURI());
if (isPublicUri(request.getRequestURI())) {
filterChain.doFilter(servletRequest, servletResponse);
return;
}
HttpServletResponse response = (HttpServletResponse) servletResponse;
boolean userContext = setUserContext(request, response);
if(userContext) {
filterChain.doFilter(servletRequest, servletResponse);
}

}
```
- If the uri is not in publicly accessible pattern then the header `X_AUTH_TOKEN` is extracted and used for setting the userContext using `  authService.setUserContext(token);`

```java
 @Override
  public void setUserContext(String tokenStr) {
    tokenStr = StringUtils.isEmpty(tokenStr) ? StringUtils.EMPTY : AppUtils.getDecodedString(tokenStr);
    AuthenticationContext context = authCacheClient.get(tokenStr);

    if(context == null){
      log.warn("authentication is null for token: {}", tokenStr);
      throw new AppRuntimeException("authentication context is empty");
    }

    if(System.currentTimeMillis() > context.getExpiryAt()){
      log.warn("authentication expired for user: {}", context.getUserId());
      throw new AppRuntimeException("token expired");
    }

    userContextService.setUser(context.getUser());
    log.info("user context set for user: {}", context.getUser());
  }
```
- Then the token which is extracted is checked if empty or null then it is set to an empty string using `StringUtils.EMPTY` else it gets decoded.
- Then the `authCacheClient` is used to check if it exists in auth-cache or `tokenMap` if exists then it returns the stored context in the value part for the given key.
- Then the expiry of the token is checked using its context.
- If every thing checks fine then method sets the user context using the user information from the authentication context.
```java
@Data
public class AuthenticationContext {
  private String userId;
  private String headerTokenUUID;
  private Long expiryAt;
  private User user;
}
``` 
- Since the AuthenticationContext contains user object it will be set for all further processing using the userContextService
```java
userContextService.setUser(context.getUser());
```  
- After all these processes then the request is sent to the controller for processing.