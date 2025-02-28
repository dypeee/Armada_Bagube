//Task 1
function calculateSum(arr) {
    let sum = 0;
    for (let i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
}
  
let numbers = [1, 2, 3, 4];
console.log("Sum:", calculateSum(numbers));

//OUTPUT:
//Sum: 10


//Task 2
function isEven(num) {
    if (num % 2 === 0) {
      return true;
    } else {
      return false;
    }
}
  
  console.log(isEven(4));
  console.log(isEven(7));
  console.log(isEven(0));

//OUTPUT:
//true
//false
//true


//Task 3
function greet(name) {
    return "Hello, " + name + "!";
}

function personalizedGreeting(names) {
    for (let i = 0; i < names.length; i++) {
      console.log(greet(names[i]));
    }
}

let friends = ["Alice", "Bob", "Charlie"];
personalizedGreeting(friends);

//OUTPUT:
//Hello, Alice!
//Hello, Bob!
//Hello, Charlie!


//Task 4
function reverseArray(arr) {
    let reversed = [];
    for (let i = arr.length - 1; i >= 0; i--) {
        reversed.push(arr[i]);
    }
    return reversed;
}

let originalArray = [10, 20, 30];
console.log(reverseArray(originalArray));
console.log(originalArray);

//OUTPUT:
//[30, 20, 10]
//[10, 20, 30]


//Task 5
function multiplyMatrix(matrix) {
  for (let i = 0; i < matrix.length; i++) {
    //0<2
    for (let j = 0; j < matrix[i].length; j++) {
        //0<2
        matrix[i][j] *= 2;
    }
  }
  return matrix;
}

let matrix = [
  [1, 2],
  [3, 4],
];
console.log(multiplyMatrix(matrix));

//OUTPUT:
//2
//4
//6
//8

//Explanation:
//Here my output computation is correct but i did not display it as a matrix