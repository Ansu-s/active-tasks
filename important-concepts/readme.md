## Cross-Origin Resource Sharing

- It is primarily a server side security feature which allows to restrict cross-origin requests. A website or web application shouldn't be able to send request to another website or application without proper permissions associated.  
- Browser employs Same-Origin-Policy thus it restricts the cross-origin requests.
- A request is considered cross-origin, if the server making the request has different domain, protocols/scheme or ports associated with it than the sender.
  - requests between `www.example.com` and `www.example.in` is considered cross-origin due to different domain names.
  - requests between `www.example.com:8080` and `www.example.in:8090` is considered cross-origin due to different ports.
  - requests between `http://www.example.com` and `https://www.example.com` is considered cross-origin due to different protocols used in the websites.  
- **CORS HEADERS**: These tells origins have permission to access its resources. Servers can include specific CORS headers in their responses to inform the browser about the access permissions.
  - Access-Control-Allow-Origin: Specifies which origins are allowed to access the resource. It can be set to a specific origin, "*" for all, or a list of origins.
  - Access-Control-Allow-Methods: Specifies the HTTP methods like GET, POST, PUT, DELETE that are allowed when accessing the resource.
  - Access-Control-Allow-Headers: Specifies the headers that are allowed when making the actual request. This header is used in response to a preflight request.
  - Access-Control-Allow-Credentials: Indicates whether the resource supports credentials (such as cookies or authorization headers). It can be either "true" or "false".
  - Access-Control-Expose-Headers: Specifies which headers are exposed to the browser in the response. This allows the browser to access headers that are not part of the CORS-safelisted response headers.
  - Access-Control-Request-Method: Used in a preflight request to indicate the HTTP method of the actual request that will be sent.
- When we are sending a request if it is other than a simple request which are `GET,POST,HEAD,OPTIONS` then a preflight options request is sent by the browser to check if the server allows the request or not. If the server sends a response with appropriate cors header then the actual request data is sent.
- Implementation of CORS helps in providing security against some cross site scripting and cross-origin attacks.
## Preflight or OPTIONS Request  
![image](https://github.com/learning-project-01/bookstore-app/assets/130679461/05374e87-19fc-4d1e-a4ae-281aab1e8695)  
- It is an HTTP request that browsers automatically send as part of the CORS policy. It is used to determine if a request is safe to send to the server.
- When the browser sends a request it is first checked the type of request which are simple or complex. The request is considered complex if it contains HTTP methods other than Simple methods, or it has some custom headers or cookies.
- After a request is considered complex then a request is sent to the browser to check if the server allows this type of request or not. Then the server responds with appropriate cors headers which can be any of Access-Control-Allow-Origin, Access-Control-Allow-Methods, Access-Control-Allow-Headers headers.
- If the response form the server is correct then the preflight request is considered success.
- If the requesting server is present in the header provided by the cors server and the HTTP methods match under the cors header then the preflight request is considered successful
- After the successful Options request then the actual request data is sent to the server.

