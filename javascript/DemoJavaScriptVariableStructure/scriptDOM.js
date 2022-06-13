// recuperer element via son id
const h1HTMLbyId = document.getElementById('title');
console.log(h1HTMLbyId);
h1HTMLbyId.innerText = "Hello World by Id";
h1HTMLbyId.innerHTML = "<em>Hello World by Id in italic</em>"

// recuperer des elements via leur class
const h1HTMLbyClass = document.getElementsByClassName('title');
h1HTMLbyClass[0].innerText = "Hello World by Class";

// recuperer des elements via leur tag
const h1HTMLbyTag = document.getElementsByTagName('h1');
h1HTMLbyTag[0].innerText = "Hello World by Tag";

// recuperer premier element via selector CSS
const h1HTMLbySelector = document.querySelector("body > h1");
h1HTMLbySelector.innerText = "Hello World by Selector";

// recuperer tous les elements via selector CSS
const h1HTMLbySelectorAll = document.querySelectorAll("body > h1");
h1HTMLbySelectorAll[0].innerText = "Hello World by Selector All";

// manipulation des classes d'un element
h1HTMLbyId.classList.add("red");
h1HTMLbyId.classList.remove("red");

// manipulation des attributs d'un element
console.log(h1HTMLbyId.getAttribute("class"));
h1HTMLbyId.setAttribute("class", "title red");
console.log(h1HTMLbyId.getAttribute("class"));

// creation des elements
const containerHTML = document.querySelector(".container");
const newH2HMTML = document.createElement("h2");
newH2HMTML.innerText = "Welcome to my website";
containerHTML.appendChild(newH2HMTML);
newH2HMTML.classList.add("red");
console.log(containerHTML.children);