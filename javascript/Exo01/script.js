const apples = { name: "Apples", price: 1, quantity: 0, total: 0 };
const pears = { name: "Pears", price: 0.5, quantity: 0, total: 0 };
const cherries = { name: "Cherries", price: 2, quantity: 0, total: 0 };
const products = [apples, pears, cherries];
let discount = true;

// get tbody element
const tbody = document.getElementById("tbody");

// ask for the amount of each product and add a row to the tbody
for (product of products) {
    product.quantity = parseInt(window.prompt("How many " + product.name + " do you want?"));
    if (product.quantity < 1) { // if the client doesn't buy any of the products then discount will not be applied
        discount = false;
    }
    product.total = product.price * product.quantity;
    let row = `<tr><td>${product.name}</td><td>${product.price.toFixed(2)}€</td><td>${product.quantity}</td><td>${product.total.toFixed(2)}€</td>`;
    tbody.innerHTML += row;
}

// show the total
const total = products.reduce((acc, product) => acc + product.total, 0);
if (discount) {
    tbody.innerHTML += `<tr><td></td><td></td><td class="red">-10% Discount</td><td class="red">${(total*0.10).toFixed(2)}€</td>`;
    tbody.innerHTML += `<tr><td></td><td></td><td class="blue">Total</td><td class="blue">${(total*0.90).toFixed(2)}€</td>`;
}
else {
    tbody.innerHTML += `<tr><td></td><td></td><td class="red">-10% discount</td><td>0€</td>`;
    tbody.innerHTML += `<tr><td></td><td></td><td class="blue">Total</td><td class="blue">${total.toFixed(2)}€</td>`;
}