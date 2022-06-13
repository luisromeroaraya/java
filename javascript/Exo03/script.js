const increaseHTML = document.getElementById("increase");
const upHTML = document.getElementById("up");
const downHTML = document.getElementById("down");
const counterHTML = document.querySelector("h2");

upHTML.addEventListener("click", (e) => {
    counterHTML.innerText = parseInt(counterHTML.innerText) + parseInt(increaseHTML.value);
});

downHTML.addEventListener("click", (e) => {
    counterHTML.innerText = parseInt(counterHTML.innerText) - parseInt(increaseHTML.value);
})