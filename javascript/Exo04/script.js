const number1HTML = document.getElementById("number1");
const number2HTML = document.getElementById("number2");
const operatorHTML = document.querySelector("select");
const equalsHTML = document.querySelector("button");
const resultHTML = document.getElementById("result");

equalsHTML.addEventListener("click", () => {
  switch (operatorHTML.value) {
    case "+":
      resultHTML.value =
        parseInt(number1HTML.value) + parseInt(number2HTML.value);
      break;
    case "-":
      resultHTML.value =
        parseInt(number1HTML.value) - parseInt(number2HTML.value);
      break;
    case "*":
      resultHTML.value =
        parseInt(number1HTML.value) * parseInt(number2HTML.value);
      break;
    case "/":
      resultHTML.value =
        parseInt(number1HTML.value) / parseInt(number2HTML.value);
      break;
    case "**":
      resultHTML.value =
        parseInt(number1HTML.value) ** parseInt(number2HTML.value);
      break;
    default:
      resultHTML.value = "Error";
  }
});