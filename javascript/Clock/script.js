// first clock
const localTimeHTML = document.getElementById('localTime')


setInterval(() => {
    const date = new Date()
    localTimeHTML.innerText = date.toLocaleTimeString()
})

// second clock

const hoursHTML = document.getElementById('hours')
const minutesHTML = document.getElementById('minutes')
const secondsHTML = document.getElementById('seconds')

setInterval(() => {
    const date = new Date()
    hoursHTML.innerText = date.getHours()
    minutesHTML.innerText = date.getMinutes()
    secondsHTML.innerText = date.getSeconds()
}, 1000);

// third clock

const hoursCounterHTML = document.getElementById('hoursCounter')
const minutesCounterHTML = document.getElementById('minutesCounter')
const secondsCounterHTML = document.getElementById('secondsCounter')

dateCounter = new Date()
let hoursCounter = dateCounter.getHours()
let minutesCounter = dateCounter.getMinutes()
let secondsCounter = dateCounter.getSeconds()

setInterval(() => {
    secondsCounter ++
    if (secondsCounter == 60) {
        minutesCounter++
        secondsCounter = 0
    }
    if (minutesCounter == 60) {
        hoursCounter++
        minutesCounter = 0
    }
    if (hoursCounter == 24) {
        hoursCounter = 0
    }
    secondsCounterHTML.innerText = secondsCounter
    minutesCounterHTML.innerText = minutesCounter
    hoursCounterHTML.innerText = hoursCounter
}, 1000)

// fourth clock
const timeoutHTML = document.getElementById('timeout')

function getDate() {
    const d = new Date()
    timeoutHTML.innerText = d.toLocaleTimeString()
    setTimeout(getDate, 1000)
}

getDate()