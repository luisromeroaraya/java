// Structure conditionelle

if (true) {
    console.log("C'est vrai 1");
}

if (1 == "1") {
    console.log("C'est vrai 2");
}

if (1 === "1") {
    console.log("C'est vrai 3");
}

const age = 18;

if (age >= 18) {
    console.log("Vous êtes majeur");
}
else if (typeof age === "number") {
    console.log("Vous êtes mineur");
}
else {
    console.log("Erreur");
}

// Switch
const ab = 42;
switch (true) {
    case ab >= 42:
        console.log("La variable vaut 42 ou plus");
        break;
    case ab < 42:
        console.log("La variable vaut moins de 42");
        break;
    default:
        console.log("La variable vaut autre chose");
        break;
}


// faux boolean
const bb = 0;
const cc = "";
if (bb) {
    console.log("Je passe dans le if");
}
if (cc) {
    console.log("Je passe dans le if");
}

// structure iterative
let i = 0
while (i < 10) {
    console.log(i);
    i++;
}

for (let j=0; j<10; j++) {
    console.log(j);
}

for (const pokemon of tab) { // pour chaque element du tableau OF
    console.log(pokemon);
}

for (const pokemon in tab) { // pour chaque index du tableau IN
    console.log(pokemon);
}

// Objects
const pokemon = {
    name: "Salameche",
    type: "Fire",
    level: 10
}
console.log(pokemon);
pokemon.type = "Water";
console.log(pokemon);

for (const key in pokemon) { // pour chaque key du tableau IN
    console.log(key);
}

for (const key in pokemon) { // pour chaque value du tableau OF
    console.log(pokemon[key]);
}

