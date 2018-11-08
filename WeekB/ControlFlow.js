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


