//incrementing, pre and post
function printNumberPlusOne(num){
    ++num; //pre increment adds one before evaluating num, num++ is post increment
    console.log(num);
    //when pass in a 3...
    //this gives 4
    console.log(num++);
    //this gives 5 (if line 7 is commented out)
    //console.log(++num);
}

//works the same with --

//for loops

//print 0-9
function forLoops(){
    for (i=0;i<10;i++){
        console.log(i);
    }
    let myObj = {"key1":"value1","key2":"value2", "key3":"value3"};
    for (x in myObj){
        console.log(x); //this is just the key
        console.log(myObj[x]); //this is the actual value
    }
}

//while loops 

//this is an infinite loop
/*
while (true) {

}
*/ 

//myBoolean is in the global scope. 
//all functions can see it, it belongs to the window object
let myBoolean = true; 

// == performs type coercion - converts second arg to dataype of first arg
// then compares

function func(){
    if (myBoolean == true) {
        console.log("my boolean is true!");
    } else {
        console.log("my boolean is false!");
    }
}

//experiment with truthy and falsy
function truthyFalsy(x){
    if (x){
        console.log(x+" is truthy");
    } else {
        console.log(x+" is falsy");
    }
}

function largestOfThree(a,b,c){
    //check whether input is of type number
    //evaluate whether the conversion to number fails for 
    //ANY of the inputs
    //if so, return NaN and exit the function
    if (isNaN(Number(a)) || isNaN(Number(b)) || isNaN(Number(c))){
        return NaN; //exit function with value NaN
    } 
    //ok, so now we can actually do the comparison!
    //only way we can get to this point in the function
    //is if the if-statement condition if not satisfied
    //(could also use an else block)

    //problem - what if a and b are equal and larger than c?
    /*
    if (a > b && a > c) {
        return a;
    } else if (b > a && b > c) {
        return b;
    } else {
        return c;
    }
    */

    //another approach
    let largest = a;

    if (b > largest) {
        largest = b;
    }
    if (c > largest) {
        largest = c;
    }

    //notice the pattern!
    //moving through other values and comparing each one to 'largest'
    //if current value is larger than 'largest', set it as 'largest'

    return largest;
}

function largestInArray(numArray) {

    let largest = numArray[0];

    for(i=1;i<numArray.length;i++){
    if(numArray[i]>largest){

        largest = numArray[i];

    }
}
    
return largest; 


    //use a loop to find largest value
}
