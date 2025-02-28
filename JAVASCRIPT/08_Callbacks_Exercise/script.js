//EXERCISE I
function calculate(num1, num2, operation) {
    return operation(num1, num2);
}

function add(a, b) {
    return a + b;
}

function multiply(a, b) {
    return a * b;
}

function subtract(a, b) {
    return a - b;
}

function divide(a, b) {
    return a / b;
}

console.log(calculate(5, 3, add));
console.log(calculate(4, 2, multiply));
console.log(calculate(10, 4, subtract));
console.log(calculate(8, 2, divide));


//EXERCISE II
function delayedMessage(message, delay, secondCallback, callback) {
    secondCallback();
    setTimeout(() => {
        callback(message);
    }, delay);
}

delayedMessage("Hello, world!", 2000,
    function () {
        console.log('Before the delay starts');
    },
    function (msg) {
        console.log(msg);
    }
);





//EXERCISE III
document.getElementById("clickMe").addEventListener("click", function () {
    console.log("Button clicked!");
});

document.getElementById("submit").addEventListener("click", function () {
    alert("Submitted!");
});



//EXERCISE IV
function repeatTask(times, callback) {
    for (let i = 0; i < times; i++) {
        if (callback(i) == false) {
            break;
        }
    }
}

repeatTask(3, function (index) {
    console.log("Iteration:", index);
    if (index === 1) {
        return false;
    }
});