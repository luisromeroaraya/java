const upHTML = document.getElementById("up");
const downHTML = document.getElementById("down");
const counterHTML = document.querySelector("h2");

upHTML.addEventListener("click", (e) => {
    counterHTML.innerText = parseInt(counterHTML.innerText) + 1;
});

downHTML.addEventListener("click", (e) => {
    counterHTML.innerText = parseInt(counterHTML.innerText) - 1;
})