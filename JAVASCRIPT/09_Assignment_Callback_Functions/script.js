//TASK 1
function customFilter(arr, callback) {
    let myArr = [];
    for (items of arr) {
        if (isEven(items)) {
            myArr.push(items);
        }
    }
    console.log(myArr);
    callback();

}

function isEven(num) {
    return num % 2 === 0;
}

var numbers = [1, 2, 3, 4, 5, 6];
var evenNumbers = customFilter(numbers, isEven);
console.log(evenNumbers);  // Output: [2, 4, 6]



//TASK 2
function countdown(start, callback) {
    callback(start);
    for (let i = 1; i <= start; i++) {
        setTimeout(() => {
        callback(start-=1)
        }, i* 1000)
    }
}
function displayNumber(num) {
    console.log(num);
}
countdown(5, displayNumber);  // Output: 5 4 3 2 1 0 (with 1-second delay between each)



//TASK 3
function createButton(buttonText, callback) {
    console.log(buttonText);
    document.getElementById("clickMe").addEventListener("click", function () {
        callback();
    });
}
function buttonClicked() {
    console.log("Button Clicked!");
}
createButton("Click Me", buttonClicked);



//TASK 4
function runTasks(tasks) {
    for (let i = 0; i < tasks.length; i++) {
        setTimeout(() => {
            tasks[i]();
        }, i*1000);
    }
}
function task1() {
    console.log("Task 1 completed");
}
function task2() {
    console.log("Task 2 completed");
}
function task3() {
    console.log("Task 3 completed");
}
runTasks([task1, task2, task3]);




//TASK 5
function askQuestion(question, choices, correctAnswer, callback) {
    console.log(question)
    console.log(choices)
    let isCorrect = false;
    let answer = '4';
    if(answer == correctAnswer){
        callback(isCorrect = true);
    }else{
        callback(isCorrect = false);
    }
}
function checkAnswer(isCorrect) {
    if (isCorrect) {
        console.log("Correct!");
    } else {
        console.log("Wrong!");
    }
}
askQuestion("What is 2 + 2?", ["1", "2", "3", "4"], "4", checkAnswer);