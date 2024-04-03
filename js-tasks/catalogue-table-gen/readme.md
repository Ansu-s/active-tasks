## Catalogue Table Dynamic Generation 

- The function loginUser() is used to retrieve the token value from login response form the server.
- To get the catalogue table data from the server function fetchCatalogItems() is used, this function sets a custom header with the value received by loginUser().
- Creating the table from the data collected from the server, the function displayTable() is used. It created a table in the html page using the collected data from the fetch request.

![Screenshot (105)](https://github.com/learning-project-01/bookstore-app/assets/130679461/b6e9f2f8-211f-463c-81c5-8dd3dc4532ec)