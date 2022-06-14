// Object
const charmander = {
    name: "Charmander",
    type: "Fire",
    level: 12,
    screams() {
        console.log(this.name + " screams!")
    }
}
charmander.screams()

const pikachu = new Pokemon("Pikachu", "Electric", 15) // from class.js
pikachu.screams()

