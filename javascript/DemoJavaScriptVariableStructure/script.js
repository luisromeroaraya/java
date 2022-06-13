// Afficher dans la console
console.log("Hello World");

// Declarer une constante
const myConstant = 5;

// Declarer une variable
let myVariable = 5;

// Ancienne notation
var myOldVariable = 5;


// Type Nombre
let a = 2;
let b = 12;

// prompt pour recuperer une valeur d'un utilisateur
// const input = parseInt(window.prompt("Entrez une valeur"));
// console.log(input);

// Pour confirmer (returns boolean)
// const confirm = window.confirm("Ok");

// Pour afficher un message
// window.alert("Alert!");

// Type chaine de charactere
const salameche = "Salameche" + " Pokemon";

const sacha = `Sacha a capturé un ${salameche}`;

console.log(sacha);

// Type boolean
const majeur = true;
const mineur = false;

// Pas de valeur
const a1 = undefined;
const a2 = null;
const a3 = NaN; //not a number

// Operateur
// + - * / %
const x = a + b * 5
console.log(x);
const exposant = a**3;
console.log(exposant);

// Tableau
const tab = ["Herbizarre", "Bulbizarre", "Pikachu", "Salameche"];
console.log(tab[0]);
console.log(tab);
tab[2] = "Kaiminus";
console.log(tab.length);
tab.push("Hericendre"); // ajoute un element a la fin du tableau
console.log(tab);
tab.pop(); // enleve le dernier element du tableau
console.log(tab);
console.log(tab.slice(1, 3)); // renvoie un tableau a partir d'un index
console.log(tab);
tab.splice(1, 1); // enleve un element a partir d'un index
console.log(tab);
tab.splice(1,1, "Raichu"); // enleve un element a partir d'un index et remplace par un autre
console.log(tab);
const newTab = tab.concat(["Ronflex", "Meowtwo"]); // renvoie une concatenation des tableau
console.log(newTab);
tab.reverse(); // inverse le tableau
console.log(tab);
tab.sort(); // trie le tableau
console.log(tab);

// Tableau nombres
const tabNombre = [5, 3, 2, 1, 4];
console.log(tabNombre);
tabNombre.sort(
    function(a, b) {
        return a - b;
    }
);

console.log(tabNombre);