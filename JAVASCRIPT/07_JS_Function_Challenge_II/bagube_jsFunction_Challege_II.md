# TASK 1
|VARIABLE               |   VALUE                                                    |
|-----------------------|------------------------------------------------------------|
| `result           `   |   `""                                                     `|
| `i                `   |   `1 increment if condition is true                       `|
| `j                `   |   `1 increment if condition is true                       `|
| `result           `   |   `""+1 + " "                                             `|
| `result           `   |   `result + newline \n                                    `|
### Output:
```
1 
1 2
1 2 3
```
# TASK 2
|VARIABLE               |   VALUE                                                    |
|-----------------------|------------------------------------------------------------|
| `numbers          `   |   `[10, 20, 30, 40]                                       `|
| `first            `   |   `10                                                     `|
| `last             `   |   `40                                                     `|
### Output:
```
[40, 20, 30, 10]
[10, 20, 30, 40]
```
# TASK 3
|VARIABLE               |   VALUE                                                    |
|-----------------------|------------------------------------------------------------|
| `scores           `   |   `[85, 45, 90, 60]                                       `|
| `passing          `   |   `[]                                                       `|
### Output:
```

```
# TASK 4
|VARIABLE               |   VALUE                                                    |
|-----------------------|------------------------------------------------------------|
| `taskList         `   |   ` { id: 1, completed: false },{ id: 2, completed: true }`|
| `task.completed   `   |   ` if boolean is true the value will be false else true  `|
### Output:
```
[{ id: 1, completed: true },{ id: 2, completed: false }]
[{ id: 1, completed: true },{ id: 2, completed: false }]
```
# TASK 5
|VARIABLE               |   VALUE                                                    |
|-----------------------|------------------------------------------------------------|
| `data             `   |   `[5, 12, 8, 130, 44]                                    `|
| `arr              `   |   `[5, 12, 8, 130, 44]                                    `|
| `target           `   |   `12>100                                                 `|
| `i                `   |   `0 if condition is true it will increment               `|
| `arr.length       `   |   `5                                                      `|
### Output:
```
Found at index 1
Not found
```

# SCRIPT.JS
```
//TASK 1
function generatePattern() {
    let result = "";
    for (let i = 1; i <= 3; i++) {
        for (let j = 1; j <= i; j++) {
            result += j + " ";
        }
        result += "\n";
    }
    return result;
}

console.log(generatePattern());
//OUTPUT
//1 
//1 2
//1 2 3


//TASK 2
function swapFirstLast(arr) {
    let first = arr.shift();
    let last = arr.pop();
    arr.unshift(last);
    arr.push(first);
    return arr;
}

let numbers = [10, 20, 30, 40];
console.log(swapFirstLast(numbers));
console.log(numbers);

//OUTPUT:
//[40, 20, 30, 10]
//[10, 20, 30, 40]


//EXPLANATION:
//My output in console.log(numbers) is incorrect i forgot that the
//array is a mutable. When the swapFirstLast function run, the
//numbers array already changed.


//TASK 3
function filterPassingGrades(grades) {
    let passing = [];
    for (let grade of grades) {
        if (grade >= 70) {
            passing.push(grade);
        } else {
            passing.unshift(grade);
        }
    }
    return passing;
}

let scores = [85, 45, 90, 60];
console.log(filterPassingGrades(scores));

//OUTPUT:
//[60, 45, 85, 90 ]


//TASK 4
function updateStatus(tasks) {
    for (let task of tasks) {
        task.completed = !task.completed;
        //false = !false
        //true = !true
    }
    return tasks;
}

let taskList = [
    { id: 1, completed: false },
    { id: 2, completed: true }
];

console.log(updateStatus(taskList));
console.log(taskList);

//OUTPUT:
//[{ id: 1, completed: true },{ id: 2, completed: false }]
//[{ id: 1, completed: true },{ id: 2, completed: false }]


//TASK 5
function findValue(arr, target) {
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === target) {
            return `Found at index ${i}`;
        }
    }
    return "Not found";
}

let data = [5, 12, 8, 130, 44];
console.log(findValue(data, 12));
console.log(findValue(data, 100));

//OUTPUT:
//Found at index 1
//Not found
```