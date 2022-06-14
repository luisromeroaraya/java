const turnHTML = document.getElementById("turn")
const winnerHTML = document.getElementById("winner")
const squaresHTML = document.getElementsByClassName("square")

let squares = [];
let counter = 0;
// 1 VS 1
// let turn = false;
// for(const square of squaresHTML) {
//     square.addEventListener("click", (e) => {
//         let index = e.target.id
//         if(!squares[index] && !winner()) {
//             if(!turn) {
//                 squares[index] = "O"
//                 document.getElementById(index).innerText = "O"
//                 turnHTML.innerText = "X"
//             }
//             else {
//                 squares[index] = "X"
//                 document.getElementById(index).innerText = "X"
//                 turnHTML.innerText = "O"
//             }
//             if(winner()) {
//                 if(turn) {
//                     winnerHTML.innerText = "X"
//                 }
//                 else {
//                     winnerHTML.innerText = "O"
//                 }
//                 turnHTML.innerText = ""
//             }
//             else if (counter < 8) {
//                 turn = !turn
//                 counter++
//             }
//             else {
//                 winnerHTML.innerText = "Tie"
//             }
//         }
//     })
// }

// 1 VS AI
for(const square of squaresHTML) {
    square.addEventListener("click", (e) => {
        let index = e.target.id
        if(!squares[index] && !winner()) {
            squares[index] = "O"
            document.getElementById(index).innerText = "O"
            if(winner()) {
                console.log("You win")
                winnerHTML.innerText = "O"
                turnHTML.innerText = ""
            }
            else if (counter < 8) {
                turn = !turn
                counter++
                turnHTML.innerText = "X"
                setTimeout(() => {
                    index = Math.floor(Math.random()*8);
                    while(squares[index]) {
                        index = Math.floor(Math.random()*8);
                    }
                    squares[index] = "X"
                    document.getElementById(index).innerText = "X"
                    turnHTML.innerText = "O"
                    if(winner()) {
                        console.log("AI wins")
                        winnerHTML.innerText = "X"
                        turnHTML.innerText = ""
                    }
                    else if (counter < 8) {
                        counter++
                    }
                    else {
                        winnerHTML.innerText = "Tie"
                    }
                }, 1000)
            }
            else {
                winnerHTML.innerText = "Tie"
            }
        }
    })
}

const resetHTML = document.getElementById("reset")
resetHTML.addEventListener("click", () => {
    for(let square of squaresHTML) {
        square.innerText = ""
    }
    squares = []
    counter = 0;
    turnHTML.innerText = "O"
    winnerHTML.innerText = ""
    // turn = false; // 1 VS 1
})

winner = () => {
    if ((squares[0] === squares[1] && squares[1] === squares[2] && squares[0] !== undefined) || 
        (squares[3] == squares[4] && squares[4] == squares[5] && squares[3] !== undefined) ||
        (squares[6] == squares[7] && squares[7] == squares[8] && squares[6] !== undefined) ||
        (squares[0] == squares[3] && squares[3] == squares[6] && squares[0] !== undefined) ||
        (squares[1] == squares[4] && squares[4] == squares[7] && squares[1] !== undefined) ||
        (squares[2] == squares[5] && squares[5] == squares[8] && squares[2] !== undefined) ||
        (squares[0] == squares[4] && squares[4] == squares[8] && squares[0] !== undefined) ||
        (squares[2] == squares[4] && squares[4] == squares[6] && squares[2] !== undefined)
        ) {
        return true
    }
    else {
        return false
    }
}