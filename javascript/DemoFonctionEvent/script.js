const inputHTML = document.querySelector("input");
const buttonHTML = document.querySelector("button");
const h2HTML = document.querySelector("h2");

// the function is triggered when the element is clicked
buttonHTML.addEventListener("click", () => {
    const inputValue = inputHTML.value; // gets the value of the input
    h2HTML.innerText = inputValue; // changes de innerText in the element h2HTML to the value of the input
    console.log(inputValue);
})

// the function is triggered when the element input receives an input
inputHTML.addEventListener("input", (event) => {
    h2HTML.innerText = event.target.value;
    console.log(event.target.value);
})

// declare functions old school
function multiplyBy2(x) {
    return x * 2;
}
console.log(multiplyBy2(5));

// declare function in a constant
const multiplyBy3 = function (x) {
    return x * 3;
}
console.log(multiplyBy3(5));

// declare arrow function
const multiplyBy4 = (x) => {
    return x * 4;
}
console.log(multiplyBy4(5));

// declare one line function
const multiplyBy5 = (x) => (x*5);
console.log(multiplyBy5(5));

// declare one line function removing parenthesis
const multiplyBy6 = x => x*6;
console.log(multiplyBy6(5));

// REST parameters
function showName(...names) {
    for (const name of names) {
        console.log(name);
    }
}
showName("James", "Max", "Therence", 45);

// function of functions
function calculate(x, callback) {
    console.log(callback(x));
}
calculate(5, multiplyBy2);

calculate(5, (x) => {
    return x * 2;
});