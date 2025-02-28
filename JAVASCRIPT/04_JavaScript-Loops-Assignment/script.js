//Task 1
let number = 5;
for (let i = 1; i <= 10; i++) {
    console.log(`${number} x ${i} = ${number * i}`);
}


//Task 2
let n = 5;
let result = 0;
for (let i = 1; i <= n; i++) {
    result = result + i;
}
console.log(`The sum of the first ${n} numbers is: ${result}`);


//Task 3
let integers = [2, 4, 6, 8, 10];
for (let i = 0; i < integers.length; i++) {
    console.log(`Array Element: ${integers[i]}`);
}


//Task 4
for (let i = 1; i <= 5; i++) {
    let asterisk = ''
    for (let j = 0; j < i; j++) {
        asterisk += '*';
    }
    console.log(asterisk)
}


//Task 5
let arr = [1, 3, 5, 7, 9];
for (let i = arr.length -1; i >= 0; i--) {
    console.log(arr[i]);
}
