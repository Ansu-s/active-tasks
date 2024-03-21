# What is happening here...? 
- We created a table in the html file by using the table tag. A table has two useful elements such as thead to represent the heading part and tbody element to crate the rows and columns of the table.
- We assigned different javascript functions to the buttons using the onclick event property.
- For rows creation the javascript function addRow() accesses the table body part by using the getElementsByTagName method.
- Then we created a new row element which is the HTML Table Row Element we added different cells to it. The function gets executed each time we press Add Row button.
- For the delete row part since we are deleting the last row we can do this by passing the index of last row.
- To get the last row index we counted the number of rows in the table and reduced it by one so we will have the index of last row which can then be passed to deleteRow() to remove the row.


![Screenshot (86)](https://github.com/learning-project-01/bookstore-app/assets/130679461/fff66460-b715-48ee-b23b-5cd6b2731513)  
![Screenshot (88)](https://github.com/learning-project-01/bookstore-app/assets/130679461/e5e1426f-5c78-4150-8b0e-b03c9e92bcfb)  
![Screenshot (89)](https://github.com/learning-project-01/bookstore-app/assets/130679461/266dcac3-4138-462b-80db-1069a75cedec)  
![Screenshot (90)](https://github.com/learning-project-01/bookstore-app/assets/130679461/6a85b178-84bd-4ccd-99df-57d4f64c9693)
