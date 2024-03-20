# Javascript Basics

Variables:
JavaScript utilizes variables as containers for storing data values.It provides different types of variable
declarations such as let, const, and var. But, let and const are block-scoped, whereas var exhibits function-scoping
behavior.

```javascript
let mynum = 10;
const pi = 3.14;
var global = "Hello world";
```

Data Types:
JavaScript incorporates dynamic typing, allowing for implicit determination of data types. Common data types include
numbers, strings, booleans, arrays and more.

```javascript
let numberVar = 42;
let stringVar = "Hello, World!";
let booleanVar = true;
```

Control Statements:
Control statements, such as if, else, switch, while, and for, govern the flow of a program, enabling decision-making and
iterative processes.

```javascript
let x = 10;
if (x > 5) {
    console.log("x is greater than 5");
} else {
    console.log("x is not greater than 5");
}
```

Functions:
Functions serve as reusable units of code, facilitating modularization through parameterization and return values.

```javascript
function add(a, b) {
    return a + b;
}

console.log(add(3, 5)); // Outputs 8
```

Arrays:
Arrays act as ordered lists, accommodating various data types and proving instrumental for grouping related data.

```javascript
let fruits = ['apple', 'orange', 'banana'];
console.log(fruits[1]); // Outputs 'orange'
```

Objects:
Objects, structured as key-value pairs, provide a means to represent entities with keys as strings or symbols and
corresponding values of any data type.

```javascript
let person = {
    name: 'user',
    age: 30,
    isStudent: false
};
console.log(person.name); // Outputs 'user'
```

# ES6 Concepts:

ES6 or ECMAScript 2015, introduced several impactful features to JavaScript, including arrow functions, template
literals, destructuring, and the use of let/const for variable declarations.
  
### Let and Const keyword  
Let allows us to declare a block scoped variable. Const create a variable whose value can't be changed.
```javascript
function hellow() {
    let x = "user";
    const name = "Aryan";
    console.log("Hello " + x + name);
}
```
### spread operator (...) 
It is used to convert an iterable of any kind like string, integers, objects into individual elements. 
```javascript
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];
const arr3 = [...arr1,...arr2]
console.log(arr3);
const str = 'hello';

output : [ 1, 2, 3, 4, 5, 6 ]
const letters = [...str];
console.log(letters)
output : ['h', 'e', 'l', 'l', 'o']
```
###  For...of loop
It's similar to foreach loop in java. It is used to iterate over iterable objects such as arrays, strings, maps or sets. 
```javascript
const str = 'hello';
for (const char of str) {
  console.log(char+ " ");
}

Output : h e l l o
```
### Javascript Maps 
These are collection of key value pairs where each key and value can be any datatype. It has methods like set(), get() and has() any many others to manipulate the map.
```javascript
const myMap = new Map();
myMap.set('key1', 'value1');
myMap.set(2, 'user');
const objKey = { id: 1 };
myMap.set(objKey, 'admin');
console.log(myMap.get('key1')); 
console.log(myMap.get(objKey));

 Output: value1 admin
```
### JavaScript Sets  
Similar to java sets javascript sets are a collection of unique values where each value can only occur once. This doesn't allow duplicate values and these are iterable like maps as well.
```javascript
const myset = new Set();
mySet.add('user1');
mySet.add(2);
const objValue = { id: 1 };
mySet.add(objValue);
console.log(mySet.has('user1'));
console.log(mySet.size);

Output : true 3
```
### Javascript Classes 
These are used for object creation of specific type. Classes provide a way to define blueprints for creating objects, these always have a constructor().
```javascript
class shape {
  constructor(type, size) {
    this.type = type;
    this.size = size;
  }
  const obj1 = new shape("circle",10);
  const obj1 = new shape("square",15);
}
```
### JavaScript Promises 
Promises provide a way to work with asynchronous operations in a more organized and manageable manner. We can produce a chain of asynchronous functions by using the promise and adding then() and catch() methods to it. The promise constructor takes only one argument which is a callback function.
The callback function takes two arguments, resolve and reject

```javascript
function greetUser(){
    return new Promise((resolve,reject) => {
        const name = prompt("Enter your name :");
        if(name){
            resolve(name);
        }else 
            reject(name);
    });
}
greetUser().then(name => {console.log("hello"+name)})
            .catch(error => {console.log("error"+error)});
```
### Symbol Type
Symbols are unique and immutable values that can be used as object property keys. These are often used to create private or non-enumerable properties in objects, as well as to avoid naming collisions in the program 
```javascript
const mySymbol = Symbol();
obj[mySymbol] = "User";
console.log(obj[mySymbol]);

Output: User
``` 
### Default Parameter Values 
We can set a default parameter value of a function. Even if the no value is passed to the function it will use the default value.
```javascript
function myFunction(x, y = 20) {
  return x + y;
}
console.log(myFunction(10));

Output : 30
```
### Function Rest Parameter(...)
This allows the function to have indefinite number of arguments as an array.
```javascript
function add(...numbers) {
  let sum = 0;
  for (let nums of numbers) sum += nums;
  return sum;
}
let x = add(4, 9, 7, 5);
console.log(x);

Output : 25
```
### String Methods (include(),startsWith(),endsWith())
String include() checks if a string contains the specified substring or not.  
String startsWith() method checks if a string starts with the specified substring.
String endsWith() checks if a string ends with the specified substring.
```javascript
const myString = "Hello, world";
console.log(myString.includes('world'));
console.log(myString.startsWith('Hello'));
console.log(myString.endsWith('worlds'));

Output : true true false 
```

### Array Methods (Array.from(), Array.keys(), Array.find())
Array.from(): This method creates a new, shallow-copied Array instance from an array-like or iterable object.
Array.keys(): This method returns a new Array Iterator object that contains the keys for each index in the array.
Array.find(): This method returns the first element in the array that satisfies the provided testing function else it returns undefined.
```javascript
const myArray = [1, 2, 3, 4, 5];
const newArray = Array.from(myArray, x => x * 2);
console.log(newArray); 

const keys = Array.from(myArray.keys());
console.log(keys);

const bigNums = myArray.find(x => x > 2);
console.log(bigNums); 

Output: [2, 4, 6, 8, 10]   [0, 1, 2, 3, 4]   3
``` 
### Math Methods (Math.trunc(), Math.sign(), Math.cbrt(), Math.log2(), Math.log10())

Math Methods (Math.trunc(), Math.sign(), Math.cbrt(), Math.log2(), Math.log10())
Math.trunc(): This method returns the integer part of a number by removing any fractional digits.
Math.sign(): It returns the sign of a number, indicating whether the number is positive, negative, or zero.
Math.cbrt(): This returns the cube root of a number.
Math.log2(): It returns the base-2 logarithm of a number.
Math.log10(): It will show the base-10 logarithm of a number.  
```javascript
const num1 = -7.2;
console.log(Math.trunc(num1));

const num3 = 10;
console.log(Math.sign(num3));

const num5 = 27;
console.log(Math.cbrt(num5));

const num6 = 8;
console.log(Math.log2(num6));


const num = 10000;
console.log(Math.log10(num));

Output : -7  1  3  3  4
```
### Math Constants (Number.EPSILON, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER)
Number.EPSILON: represents the difference between 1 and the smallest floating point number greater than 1
Number.MIN_SAFE_INTEGER: represents the minimum safe integer in JavaScript, which is -(2^53 - 1) or 9007199254740991
Number.MAX_SAFE_INTEGER: This property represents the maximum safe integer in JavaScript, which is 2^53 - 1
```javascript
console.log(Number.EPSILON);
console.log(Number.MIN_SAFE_INTEGER);
console.log(Number.MAX_SAFE_INTEGER);

Output: 2.220446049250313e-16
        -9007199254740991
         9007199254740991
```
### Global Number Methods (isNaN(), isFinite()) 
Number.isFinite(): It checks if the passed value is a finite number, it returns true if the value is a finite number.
Number.isNaN(): It checks if the given input is a number or not, it returns true if the value is not a number or else returns false.
```javascript
console.log(Number.isFinite(123));
console.log(Number.isFinite(-Infinity));
console.log(Number.isNaN("hello")); 
console.log(Number.isNaN(1263));

Output : true  false  false  true
```
### Arrow Function:
These are similar to lambda functions in java. They don't have this keyword so these are not used widely for object methods.
Arrow functions are not hoisted, so we have to declare them before their usage.We can declare a function without the return statement and 
curly braces if there is only a single statement present in the function.
```javascript
const multiply = (a, b) => a * b;

function Counter() {
    this.count = 0;
    setInterval(() => {
        this.count++;
        console.log(this.count);
    }, 1000);
}

let counter = new Counter();
```

### Template Literals:

```javascript
let name = 'username@1';
console.log(`Hello, ${name}!`);

let user = {
    name: 'user1',
    age: 28,
    city: 'BBSR',
    hobbies: ['Reading', 'Coding', 'Traveling'],
};

function generateUserProfile(user) {
    return `
        <div class="user-profile">
            <h2>${user.name}</h2>
            <p>Age: ${user.age}</p>
            <p>City: ${user.city}</p>
            <h3>Hobbies:</h3>
            <ul>
                ${user.hobbies.map(hobby => `<li>${hobby}</li>`).join('')}
            </ul>
        </div>
    `;
}

let userProfile = generateUserProfile(user);
console.log(userProfile);

Output:
    <h2>user1</h2>
<p>Age: 28</p>
<p>City: BBSR</p>
<h3>Hobbies:</h3>
<ul>
    <li>Reading</li>
    <li>Coding</li>
    <li>Traveling</li>
</ul>

```

### Destructuring:

```javascript
let [first, second] = [1, 2];
let person = {name: 'user', age: 30, city: 'IND'};
let personName = person.name;
let personAge = person.age;
// Destructuring
let {name, age} = person;

console.log(name); // Outputs 'user'
console.log(age);  // Outputs 30

// Destructuring and  Default Values
let user = {username: 'guest', role: 'user'};
let {username, role = 'guest'} = user;

console.log(username); // Outputs 'guest'
console.log(role);     // Outputs 'user' value from the object
```
### Object.entries() 
It is used to return an array of a given object's own enumerable string-keyed property in key : value pairs and this maintains the insertion order.
```javascript
const obj = { a: 1, b: 2, c: 3 };
const entries = Object.entries(obj);
console.log(entries);

Output : [['a', 1], ['b', 2], ['c', 3]]
```
### Javascript Modules 
In a project we have different javascript files , we can use the "import" or "export" statement in a module to import or export variables, functions, classes or any other file or module. This increases the code re-usability.
```javascript
// This function is in math.js
export function add(a, b) {
  return a + b;
}
// We can use it result.js
import { add } from './math.js';

const result = add(2, 3);
console.log(result); 

Output : 5 
```
