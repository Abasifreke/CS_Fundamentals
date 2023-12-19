/*
Part 1: Implement a simplified Promise constructor in JavaScript. This constructor should be used in the form:
let promise = Promise((resolve) => {
    // potentially async code here
})
and should let us do something like:
promise.then((val) => console.log(`done with value ${val}`));
The promise should allow multiple uses of then, and when then is called after the promise is fulfilled, it should immediately invoke the function.


*/

let promise = new Promise((resolve) => {
    // potentially async code here

})

class Promise {
    resolveResult;

    constructor(resolve) {
       resolveResult = resolve();
    }


    function then(printConsole){
       printConsole(resolveResult);
    }

    function printConsole(val){
        console.log(`done with value ${val}`)
    }
}
