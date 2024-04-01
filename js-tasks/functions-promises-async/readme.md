## Higher Order Functions:
Higher Order Functions are functions that can take other functions as arguments or return functions as their output. These are part of functional programming. These increase the modularity and reusability of the code. Filter,map,reduce are most useful higher order functions.

Higher Order Functions have two main functionalities they are:
- Can accept Functions as Arguments

- Returns a Function as their result

```javascript
function calculate(x, y, operation) {
    return operation(x, y);
}

function add(a, b) {
    return a + b;
}

function multiply(a, b) {
    return a * b;
}

console.log(calculate(5, 3, add)); 
console.log(calculate(5, 3, multiply));


function claculateFactor(factor) {
    return function (number) {
        return number * factor;
    };
}

const output = claculateFactor(2);
const output = claculateFactor(3);

console.log(double(5)); 
console.log(triple(5));
```
## Callback Hell:
It is a situation in asynchronous JavaScript programming where multiple nested callback functions make the code difficult to read and understand  
It occurs when there are numerous asynchronous operations dependent on each other which causes nested callbacks
To avoid this we should use: 
- Use promises to make the code more understandable
- To avoid nested callbacks use async and await
```javascript

asyncOperation1(arg1, (err1, result1) => {if (err1) {
        console.error("error in function", err1);
    } else {asyncOperation2(result1, (err2, result2) => {if (err2) {
                console.error("error here", err2);
            } else {asyncOperation3(result2, (err3, result3) => {
                    if (err3) {console.error("error", err3);} else {console.log("output", result3);}});
    }
    });
    }
});
```
## Async/Await:
An async function is defined using the async keyword before the function declaration. It allows the function to operate asynchronously, returning a promise that resolves to the function's return value thus making them suitable for I/O bound jobs.  
is used to pause the execution of the function until a promise is either resolved or rejected. It waits for the promise to resolve and then return the value
```javascript
async function fetchData() {
    const data = await fetch("http://localhost:8080/user/login");
    return data.json();
}
```
## Promises: 
Promises are objects representing the eventual completion or failure of an asynchronous operation or function, they have two primary states such as pending or settled 
```javascript
function fetchData() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            const data = { id: 1, name: "user1"};
            resolve(data);
            }, 2000);
    });
}
fetchData()
    .then(data => {
        console.log("Data", data);
    })
    .catch(error => {
        console.error("Error", error);
    });
```
