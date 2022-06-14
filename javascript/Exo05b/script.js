const cards = [
    0, 6, 2, 1,
    3, 7, 5, 4,
    4, 1, 3, 2,
    0, 5, 7, 6
]

const guess = []
let index1

cardsHTML = document.getElementsByClassName("card")

for(const card of cardsHTML) {
    card.addEventListener("click", (e) => {
        const index = e.target.id
        if (guess.length === 0) {
            document.getElementById(index).innerText = cards[index]
            guess.push(index)
            index1 = index;
        }
        else if (index1 !== index) {
            document.getElementById(index).innerText = cards[index]
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