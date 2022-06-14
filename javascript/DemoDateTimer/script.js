// DateTime

const d = new Date()

console.log(d.getDay()) // day of the week from 0-6 (sunday to saturday)
console.log(d.getDate()) // date of the day
console.log(d.getMonth()) // get month from 0-11
console.log(d.getFullYear()) // get 4 digit year
console.log(d.toString()) // Day Month dd yyyy hh:mm:ss GMT
console.log(d.toDateString()) // Day Month dd yyyy
console.log(d.toLocaleDateString()) // dd/mm/yyyy
console.log(d.toLocaleTimeString()) // hh:mm:ss
console.log(d.getTime()) // miliseconds

// Timer
const timer = setTimeout(() => {
    console.log("Hello")
}, 2000)

console.log("Goodbye")
// "If timer has a timeout value of 0 "Goodbye" is still going to appear first because every async function (like setTimeout) is going to be executed at the end

clearTimeout(timer) // stops the timer function so it never gets executed

const interval = setInterval(() => { // an Interval loops eternally until the clearInterval function is called
    console.log("setInterval")
    clearInterval(interval) // stops the Interval
}, 2000)