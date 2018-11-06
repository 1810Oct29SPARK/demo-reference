//applying an event listener to the Window object 
//when the window loads, this function will be executed
window.onload = function(){
    console.log("hello world");
}

function calculate(num1, num2, operation){
    let result=NaN;
    if (operation === "add"){
        result = num1+num2;
    }
    if (operation === "subtract"){
        result = num1-num2;
    }
    if (operation === "divide"){
        result = num1/num2;
    }
    if (operation === "multiply"){
        result = num1*num2;
    }
    return result;
}