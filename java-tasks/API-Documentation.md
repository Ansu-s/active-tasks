# Create User API
### Endpoint Details  

- URL: `[POST]  /user/signup`
- Allowed Methods: POST

### Description
This endpoint facilitates the creation of new user accounts in the bookstore application. Users can utilize this endpoint by sending a POST request to `/user/signup`, providing essential user information in the request body in JSON format.
### Request Body 
```json
{
  "firstName": "string",
  "lastName": "string",
  "email": "string",
  "password": "string",
  "role": "string"
}
```
### Url Parameters
This endpoint doesn't require any specific url parameters expect the request body
> The `email`, `password` and `role` are required fields in the request body, Omission in any of these fields will result in a `400 Bad Request` error

### Example
    [POST] localhost:8080/user/signup
#### Example Request Body  
```json
{
    "firstName": "User1",
    "lastName": "Test1",
    "email": "users@email.com",
    "password": "1234@abc",
    "role": "ADMIN"
}
```  
```
curl --location 'localhost:8080/user/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "User1",
  "lastName": "Test1",
    "email": "users@email.com",
    "password": "1234@abc",
    "role": "ADMIN"
}'
```
#### Example Response
    HTTP 200 OK
``` json
{
    "id": 113222043008700,
    "email": "users@email.com",
    "password": "[PROTECTED]",
    "firstName": "User1",
    "lastName": "Test1",
    "role": "ADMIN"
}
```

### Errors
Http Code | Verbose Code          | Description
--- |-----------------------| ---
400 | Bad Request           | Necessary fields not passed in request body
401 | Unauthorised Access   | Improper authentication provided with the request
500 | Internal server error | Request couldn't be processed by the server
#### Error Response
    HTTP 400 Bad Request
``` json
{
    "timestamp": "2024-04-16T11:54:25.621+00:00",
    "status": 400,
    "error": "Bad Request",
    "path": "/user/signup"
}
```



