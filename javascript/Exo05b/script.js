const cards = [
    "white", "purple", "yellow", "blue",
    "orange", "green", "pink", "red",
    "red", "blue", "orange", "yellow",
    "white", "pink", "green", "purple"
]

const guess = []
let index1

cardsHTML = document.getElementsByClassName("card")

for(const card of cardsHTML) {
    card.addEventListener("click", (e) => {
        const index = e.target.id
        if (guess.length === 0) {
            document.getElementById(index).classList.add(cards[index])
            guess.push(index)
            index1 = index;
        }
        else if (index1 !== index) {
            document.getElementById(index).classList.add(cards[index])
            guess.push(index)
        }
        else {
                    
        }
        console.log(guess)
    })
}

equal = () => {
    if(guess[0] === guess[1] && guess[0] !== undefined) {
        return true
    }
    else {
        return false
    }
}