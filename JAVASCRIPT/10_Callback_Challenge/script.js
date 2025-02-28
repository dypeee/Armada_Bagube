// TASK 1
function customMap(numbers, callback) {
    let result = [];
    for (let i = 0; i < numbers.length; i++) {
        result.push(callback(numbers[i]));
    }
    return result;
}

let numbers = [1, 2, 3];
let doubled = customMap(numbers, function (num) { return num * 2; });
console.log(doubled); // Should output: [2,4,6]


// // TASK 2
// function filter(arr, callback) {
//     let result = [];
//     for (let i = 0; i < arr.length; i++) {
//         if (callback(arr[i])) {
//             result.push(arr[i]);
//         }
//     }
//     return result;
// }

// let result = filter([1, 2, 3, 4, 15], function (val) { return val < 10; });
// console.log(result); // Should output: [1,2,3,4]



// // TASK 3
// function some(arr,callback){
//     for (let i = 0; i < arr.length; i++) {
//         if (callback(arr[i])) {
//             return false;
//         }
//     }
//     return true;
// }

// let result = some([1,2,3,4], function(val) { return val>5; });
// console.log(result); // Should output: true


// // TASK 4
// function every(arr,callback){
//     for (let i = 0; i < arr.length; i++) {
//         if (!callback(arr[i])) {
//             return false
//         }
//     }
//     return true;
// }

// let result = every([1,2,3], function(val) { return val>0; });
// console.log(result); // Should output: true


// // TASK 5
// function reduce(arr, callback) {
//     let sum = 0;
//     for (let i = 0; i < arr.length; i++) {
//         sum = callback(sum,arr[i]);
//     }
//     return sum;
// }

// let sum = reduce([1, 2, 3], function (acc, num) { return acc + num; });
// console.log(sum); // Should output: 6

// // TASK 6
// function includes(arr, callback) {
//     for (let i = 0; i < arr.length; i++) {
//         if (callback(arr[i])) {
//             return true;
//         }
//     }
//     return false;
// }
// let result = includes([1, 2, 3], function (val) { return val === 2; });
// console.log(result); // Should output: true