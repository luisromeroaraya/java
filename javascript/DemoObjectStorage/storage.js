const name = localStorage.getItem("name")
if (name) {
    console.log("Hello " + name + ".")
}
else {
    const newName = prompt("What is your name?")
    localStorage.setItem("name", newName)
    console.log("Your name was saved.")
}