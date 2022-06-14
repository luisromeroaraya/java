const number1HTML = document.getElementById("number1");
const number2HTML = document.getElementById("number2");
const operatorHTML = document.querySelector("select");
const equalsHTML = document.getElementById("equals");
const resultHTML = document.getElementById("result");

equalsHTML.addEventListener("click", () => {
  resultHTML.value = `${number1HTML.value} ${operatorHTML.value} ${number2HTML.value} = `;
  switch (operatorHTML.value) {
    case "+":
      resultHTML.value +=
        parseInt(number1HTML.value) + parseInt(number2HTML.value);
      break;
    case "-":
      resultHTML.value +=
        parseInt(number1HTML.value) - parseInt(number2HTML.value);
      break;
    case "*":
      resultHTML.value +=
        parseInt(number1HTML.value) * parseInt(number2HTML.value);
      break;
    case "/":
      resultHTML.value +=
        parseInt(number1HTML.value) / parseInt(number2HTML.value);
      break;
    case "**":
      resultHTML.value +=
        parseInt(number1HTML.value) ** parseInt(number2HTML.value);
      break;
    default:
      resultHTML.value = "Error";
  }
});

// calculator

let number1 = undefined;
let number2 = undefined;
let operator = undefined;

const calculatorHistoryHTML = document.getElementById("calculator-history");
const calculatorResultHTML = document.getElementById("calculator-result");
const calculatorButtonsHTML = document.getElementsByClassName("calculator-button");

for (button of calculatorButtonsHTML) {
  button.addEventListener("click", (e) => {
    if ("+-*/".includes(e.target.innerText)) {
      if (!number1) {
        number1 = calculatorResultHTML.value;
        console.log("number 1: " + number1);
      } else {
        number2 = calculatorResultHTML.value;
        console.log("number 2: " + number2);
      }
      calculatorHistoryHTML.value = `${calculatorHistoryHTML.value}${e.target.innerText}`;
      calculatorResultHTML.value = "";
      operator = e.target.innerText;
    } else if ("=".includes(e.target.innerText)) {
      number2 = calculatorResultHTML.value;
      console.log("number 2: " + number2);
      calculatorHistoryHTML.value = `${calculatorHistoryHTML.value}${e.target.innerText}`;
      switch (operator) {
        case "+":
          calculatorResultHTML.value = parseInt(number1) + parseInt(number2);
          break;
        case "-":
          calculatorResultHTML.value = parseInt(number1) - parseInt(number2);
          break;
        case "*":
          calculatorResultHTML.value = parseInt(number1) * parseInt(number2);
          break;
        case "/":
          calculatorResultHTML.value = parseInt(number1) / parseInt(number2);
          break;
        default:
          calculatorResultHTML.value = "Error";
      }
      calculatorHistoryHTML.value = `${calculatorHistoryHTML.value}${calculatorResultHTML.value}`;
    } else if (e.target.innerText.includes("C")) {
      calculatorHistoryHTML.value = "";
      calculatorResultHTML.value = "";
      number1 = undefined;
      number2 = undefined;
      console.log("number 1: " + number1);
      console.log("number 2: " + number2);
    } else {
      calculatorHistoryHTML.value = `${calculatorHistoryHTML.value}${e.target.innerText}`;
      calculatorResultHTML.value = `${calculatorResultHTML.value}${e.target.innerText}`;
    }
  });
}
