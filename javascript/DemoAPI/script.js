const URL = "https://api.agify.io?name=__name__"

const inputHTML = document.getElementById("name");
const buttonHTML = document.getElementById("button");
const ageHTML = document.querySelector("span")

buttonHTML.addEventListener("click", () => {
    const name = inputHTML.value.normalize('NFD').replace(/([\u0300-\u036f]|[^0-9a-zA-Z])/g, '');
    fetch(URL.replace("__name__", name))
        .then(response => response.json())
        .then(data => {
            console.log(data);
            ageHTML.innerText = data.age;
        })
        .catch(e => {
            console.log("Error");
        })
    console.log("Bonjour");
});