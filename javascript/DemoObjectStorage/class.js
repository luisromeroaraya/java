//Class
class Pokemon {
    #name = 0 // to set a default name
    constructor(name, type, level) {
        this.name = name
        this.type = type
        this.level = level
    }
    // getters
    getName() {
        return this.name
    }

    getType() {
        return this.type
    }

    getLevel() {
        return this.level
    }

    //methods
    screams() {
        console.log(this.getName() + " screams!")
    }
}