### Javascript Function
- Functions in js are a block of code which can be executed when called upon
- These are needed to be called upon to start the execution process
- The name of the function is preceded by the keyword function  
```javascript
function hello(){console.log("Hello World")}
```

### Parameterized Functions
- It is a javascriprt function which takes some inputs as arguements or parameters and can use them inside the function program
- Rest parameters : we can make a function accept any number of parameters by use the three dots before a parameter name like `...params`. It allows a function to accept an indefinite number of arguments as an array  
```javascript
function Hello (...params){
    console.log("Hello "+params)
}
```
### Arrow Functions 
- It is a short way of writting functions
- These are anonymous functions,there can be functions without a name but they are often assigned to any variable 

```javascript
const hello = () => {console.log("Hello world")}
```