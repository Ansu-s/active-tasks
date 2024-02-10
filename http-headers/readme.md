## Http Request Headers
![Screenshot (265)](https://github.com/learning-project-01/bookstore-app/assets/130679461/c299487e-edf9-4398-b213-4d89c4d39ee5)   

![Screenshot (266)](https://github.com/learning-project-01/bookstore-app/assets/130679461/9a7f43f7-f789-4978-9272-ff4e61ea9529)  

![Screenshot (268)](https://github.com/learning-project-01/bookstore-app/assets/130679461/32068ea9-84eb-4afa-857e-0413ee0c673f)  


```CURL
curl --location 'http://localhost:8080/user/login' \
--header 'Browser: Mozilla' \
--header 'Authentication: Basic Auth' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic YW5zdUBnbWFpbC5jb206YW5zdTEyMw==' \
--data-raw '{
    "email":"ansu@gmail.com",
    "password":"ansu123",
     "firstName":"Ansu",
    "lastName": "user2",
    "role": "ADMIN" 
}'
```

HTTP headers contain metadata in key-value pairs that are sent along with HTTP requests and responses. They can be used to define caching behavior, facilitate authentication, and manage session state.  

HTTP request headers are additional pieces of information sent by a client (such as a web browser) to a server along with an HTTP request. These headers provide various details about the request and help the server understand how to process it.  
  
Most common headers are as follows:  
- **Host:** Specifies the host and port to which the request is being sent.

- **User-Agent:** Identifies the client making the request, typically including information about the browser or application.

- **Accept:** Indicates the media types that the client can handle in the response, such as HTML, JSON, or XML.

- **Accept-Language:** Specifies the preferred languages for the response content.

- **Accept-Encoding:** Indicates the encodings that the client can accept for the response body, such as gzip or deflate.

- **Connection:** Controls whether the connection should be kept alive after the request is completed.

- **Content-Type:** Specifies the MIME type of the request body when sending data to the server, such as application/json or application/x-www-form-urlencoded.

- **Authorization:** Provides credentials for authenticating the client with the server, often used for HTTP basic or bearer authentication.

- **Cookie:** Sends previously stored cookies back to the server, allowing for session management and tracking user state.

- **Cache-Control:** Specifies directives for caching behavior, such as whether the response can be cached and for how long.

- **Referer:** Indicates the URL of the page that referred the client to the current page.

## Basic Authentication
Basic authentication is a simple authentication mechanism used in HTTP protocol. It allows a client to provide credentials (username and password) when making an HTTP request to a server. The server then validates these credentials before processing the request. Here's how it works:

**Client Request:** When a client wants to access a protected resource on the server, it includes an Authorization header in the HTTP request. The header contains the word "Basic" followed by a space and a base64-encoded string representation of the username and password concatenated with a colon (username:password).

**Server Validation:** Upon receiving the request, the server extracts the username and password from the Authorization header. It then verifies the credentials against its authentication system, such as a user database or directory service.

**Response:** If the credentials are valid, the server grants access to the requested resource and returns the appropriate response (e.g., status code 200 OK). If the credentials are invalid, the server returns a status code indicating authentication failure (e.g., 401 Unauthorized) along with a WWW-Authenticate header to prompt the client to provide valid credentials.  

## Bearer Token

A bearer token is a type of access token commonly used in authentication and authorization mechanisms, particularly in OAuth 2.0 and JSON Web Token (JWT) based systems. It is called a "bearer" token because whoever possesses it can use it to access protected resources, much like a bearer of a physical token.

Working of a bearer token:

**Obtaining a Token:** A client (such as a user agent or a third-party application) obtains a bearer token from an authorization server by presenting credentials or through some other authentication mechanism.

**Using the Token:** The client includes the bearer token in the HTTP Authorization header when making requests to access protected resources on a resource server. The token is usually included in the form of Bearer <token>.

**Validation:** Upon receiving a request with a bearer token, the resource server validates the token to ensure its authenticity and integrity. This typically involves verifying the token's signature (if it's a JWT) or consulting with the authorization server to confirm the token's validity.

**Access Control:** Once the bearer token is successfully validated, the resource server grants access to the requested resource based on the permissions associated with the token.

## JWT Token

It stands for JSON Web Token. It is  a compact, URL-safe means of representing claims securely between the client and the server. It is a self-contained token that contains JSON data encoded in a secure manner. JWTs are commonly used for authentication and authorization in web applications and APIs.  
  
Main components of a JWT token are as follows,   
**Header:** The header typically consists of two parts: the type of token (JWT) and the signing algorithm being used, such as HMAC SHA256 or RSA.  


**Payload (Claims):** The payload contains the claims, which are statements about an entity (typically the user) and additional data.   
  
Claims can be categorized into three types:
- **Registered claims:** Predefined claims recommended by the JWT standard, such as issuer (iss), subject (sub), audience (aud), expiration time (exp), and others.
- **Public claims:** Custom claims defined by the parties involved in the communication.
- **Private claims:** Custom claims specific to the application or organization but not standardized.

**Signature:** The signature is created by combining the encoded header, encoded payload, and a secret key (or public/private key pair) using the specified algorithm. The signature ensures the integrity of the JWT and allows parties to verify its authenticity.  

## Authentication & Authorization  

1. **Authentication**:
    - Authentication is the process of verifying the identity of a user, system, or entity attempting to access a resource or service.
    - It ensures that the user is who they claim to be before granting access to protected resources.
    - Authentication mechanisms typically involve presenting credentials, such as usernames, passwords, tokens, or biometric data, and validating them against a trusted source, such as a user database or identity provider.
    - Successful authentication establishes trust in the identity of the user, allowing them to proceed with accessing authorized resources.

2. **Authorization**:
    - Authorization is the process of determining what actions or resources a user is allowed to access or perform after they have been authenticated.
    - It involves enforcing access control policies based on the authenticated user's identity, roles, permissions, or other attributes.
    - Authorization mechanisms define rules and policies that govern who can access specific resources, what operations they can perform, and under what conditions.
    - Authorization typically occurs after authentication and relies on information about the user's identity and associated permissions.  

## HTTP Methods and why are some considered Idempotent 

HTTP (Hypertext Transfer Protocol) defines several request methods or HTTP verbs that indicate the desired action to be performed on a resource.   

Some common HTTP methods include:

1. **GET**: Retrieves data from the server. It should only retrieve data and should not have any other effect on the server.

2. **POST**: Submits data to the server to be processed. It often results in the creation or update of a resource on the server.

3. **PUT**: Updates a resource on the server with the provided data. It replaces the entire resource with the new data.

4. **DELETE**: Deletes a resource from the server.

5. **PATCH**: Applies partial modifications to a resource. It's used to update part of a resource's state.

6. **HEAD**: Similar to GET, but only retrieves the headers of the response without the body. It's often used to check the headers or metadata of a resource without retrieving its full content.

7. **OPTIONS**: Requests information about the communication options available for the target resource, such as supported HTTP methods.

8. **TRACE**: Echoes the received request back to the client. It's primarily used for diagnostic purposes and should be disabled in production environments due to security concerns.

Among these methods, GET, HEAD, PUT, and DELETE are considered idempotent. An idempotent operation is one that can be performed multiple times without changing the result beyond the initial application. In the context of HTTP methods:

- **GET**: Retrieving the same resource multiple times using the GET method will always return the same resource, so it is considered idempotent.

- **HEAD**: Similar to GET, retrieving the headers of a resource using the HEAD method multiple times will always return the same headers, making it idempotent.

- **PUT**: Updating a resource with the same data using the PUT method multiple times will always result in the same state of the resource, so it is idempotent.

- **DELETE**: Deleting a resource using the DELETE method multiple times will not change the state of the resource after the first deletion, so it is also idempotent.

## Status Codes
1. **200 OK**: Request successful, server fulfilled the client's request.
2. **201 Created**: New resource created successfully.
3. **202 Accepted**: Request accepted for processing, but not completed yet.
4. **500 Internal Server Error**: Server encountered an unexpected condition.
5. **502 Bad Gateway**: Server received an invalid response from an upstream server.
6. **503 Service Unavailable**: Server currently unable to handle the request.
7. **404 Not Found**: Requested resource not found on the server.
8. **406 Not Acceptable**: Server cannot generate a response meeting client's criteria.
9. **415 Unsupported Media Type**: Server refuses to accept request due to unsupported media type.
10. **302 Found**: Requested resource temporarily moved to a different URI.

![image](https://github.com/learning-project-01/bookstore-app/assets/130679461/2d62f3fb-cf8e-41a5-9cef-3218b52c544a)
### CURL status code: use -i or --include flag to see
![image](https://github.com/learning-project-01/bookstore-app/assets/130679461/cf1e68ee-2ab3-4731-8b51-96a255d8bc3a)  

## CORS 
CORS (Cross-Origin Resource Sharing) is a security feature implemented by web browsers to restrict cross-origin HTTP requests initiated from within scripts. It is a mechanism that allows servers to specify which origins are permitted to access resources from the server.  
  
CROS is used in spring boot to provide the below features

**Security:** CORS helps prevent malicious websites from accessing sensitive data on other websites.  

**Cross-Domain Communication:** CORS enables web pages from one domain to make requests to resources on another domain.  

**API Access Control:** It allows servers to control which origins can access their APIs and resources.

To implement it in a spring boot application :
- Create a new Java class for CORS configuration, e.g., `CorsConfig.java`.
- Implement the `WebMvcConfigurer` interface in the `CorsConfig` class.
- Override the `addCorsMappings` method within the `CorsConfig` class.
- Configure CORS settings using the `CorsRegistry` object:
   - Use `registry.addMapping("/**")` to specify the mapping path.
   - Use `.allowedMethods("*")` to allow all HTTP methods.
   - Use `.allowedHeaders("*")` to allow all headers.
- With this configuration, your Spring Boot app will allow cross-origin requests from any origin, method, and header. Adjust settings as needed.
