URL = "https://opentdb.com/api.php?amount=1&type=multiple"
const categoryHTML = document.getElementById("category")
const questionHTML = document.getElementById("question")
const answersHTML = document.getElementById("answers")
const correctionHTML = document.getElementById("correction")
const nextQuestionHTML = document.getElementById("nextQuestion")

let answer;
let buttons;

async function getNextQuestion() {
    fetch(URL)
    .then(response => response.json())
    .then(data => {
        const question = data.results[0]
        const answers = getAnswers(question)
        categoryHTML.innerText = question.category
        questionHTML.innerText = question.question
        createOptions(answers)
        console.log(question)
    })
}

function getAnswers(question) {
    answer = question.correct_answer
    const answers = []
    for(i=0;i<4;i++){
        if(i == 3) {
            answers.push(question.correct_answer)
        }
        else {
            answers.push(question.incorrect_answers[i])
        }
    }
    shuffle(answers)
    return answers
}

function shuffle(array){
    array.sort(() => Math.random() - 0.5)
}

function createOptions(answers){
    for(element of answers) {
        const answerHTML = document.createElement("button")
        answerHTML.classList.add("answer")
        answerHTML.innerHTML = element
        answersHTML.appendChild(answerHTML)
        answerHTML.addEventListener("click", (e) => {
            if (e.target.innerText == answer) {
                e.target.classList.add("green")
                correctionHTML.innerText = "CORRECT"
            }
            else {
                correctionHTML.innerText = "INCORRECT"
            }
        })
    }
    buttons = document.getElementsByClassName("answer")
    console.log(buttons)
}

nextQuestionHTML.addEventListener("click", () => {
    for (element of buttons) {
        answersHTML.removeChild(element)
    }
})

getNextQuestion()