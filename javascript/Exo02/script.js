// ask for the number of contestants
const quantity = parseInt(prompt("How many people are going to participate?"));

// show the quantity of contestants on the HTML
const quantityHTML = document.getElementById("quantity");
quantityHTML.innerText = quantity;

const contestants = [];
const contestantsHTML = document.getElementById("contestants");
// ask for the name of each of the contestant and add it to the array
for (i=0; i<quantity; i++) {
    let contestant = prompt("Enter the name of the next contestant:");
    contestant = contestant.charAt(0).toUpperCase() + contestant.slice(1);
    contestants.push(contestant);
    contestantsHTML.innerHTML += `<li>${contestant}</li>`; // add the contestant to the ordered list in the HTML
}

// generate a random index from 0-n where n is the length of the contestants array
const random  = Math.floor(Math.random()*contestants.length);
const winner = contestants[random];

// show the winner in the h3 element
const winnerHTML = document.getElementById("winner");
winnerHTML.innerText = winner;

// show some variables on the console
console.log(`Random index: ${random}`);
console.log(contestants);