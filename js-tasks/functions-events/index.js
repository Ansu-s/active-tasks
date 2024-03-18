function hello() {
    alert("Hello");
}

function alertUser(){
    var nameField = document.getElementById("name").value;
    window.alert("Hey user " + nameField);
}

function addNums(){
    var num1 = parseFloat(document.getElementById("num1").value);
    var num2 = parseFloat(document.getElementById("num2").value);
   
    var sum = num1 + num2;
   
    document.getElementById("result").innerText = "The sum is : " + sum;
}