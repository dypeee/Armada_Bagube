//TASK 1
let inventory = ["apple", "banana", "cherry", "date", "elderberry"];
let inventoryCount = [10, 15, 5, 20, 7];
for (let i = 0; i < inventory.length; i++) {
	console.log(`${inventory[i]}: ${inventoryCount[i]}`);
}

// OUTPUT:
//apple: 10
//banana: 15
//cherry: 5
//date: 20
//elderberry: 7

//Explanation:
// The for loops starts with zero and ends with the length of inventory
// and by using the inventory[i] it will show the item where index i the same with Inventory Count array


//TASK 2
let words = ["zebra", "apple", "mango", "cherry", "banana"];
for (let i = 0; i < words.length; i++) {
	for (let j = i + 1; j < words.length; j++) {
		if (words[i] > words[j]) {
			let temp = words[i];
			words[i] = words[j];
			words[j] = temp;
		}
	}
}
console.log(words);

//OUTPUT:
//['apple','banana','cherry','mango','zebra']

//Explanation:
// The first for loops is the item you compare to the second loop. 
// For example the zebra compare it to the next item and if the word[i] which is the zebra greater than the words [j] which is apple
// they will swap the value, the zebra will be store in the variable temp and the words[j] will be store in words[i]
// and the temp will be store in words[j]. The result of the first round of the loop will be ["apple", "zebra", "mango", "cherry", "banana"].



//Task 3
let uniqueNumbers = [];
while (uniqueNumbers.length < 10) {
	let randomNumber = Math.floor(Math.random() * 20) + 1;
	let exists = false;
	for (let i = 0; i < uniqueNumbers.length; i++) {
		if (uniqueNumbers[i] === randomNumber) {
			exists = true;
			break;
		}
	}
	if (!exists) {
		uniqueNumbers.push(randomNumber);
	}
}
console.log(uniqueNumbers);

//OUTPUT:
// [19, 18, 7, 20, 13, 5, 6, 11, 8, 1]

//Explanation:
// There is a while loop to create a list of the random number. I expected to have 10 list because of the condition.
// Math.floor will just get the whole number and inside of it is Math.random to generate random number. Then initialize 
// the exists = false to trigger the push randomNumber. And now the filtering of a duplicate number. They use here
// the if else condition if unique number is equal to the random Number then the exist will change the value into true
// and after the if the not exist it will not push the randomNumber


//TASK 4
let sideA = 7;
let sideB = 10;
let sideC = 5;
if (sideA + sideB > sideC && sideB + sideC > sideA && sideA + sideC > sideB) {
	console.log(`The sides ${sideA}, ${sideB}, and ${sideC} form a valid triangle.`);
} else {
	console.log(`The sides ${sideA}, ${sideB}, and ${sideC} do not form a valid triangle.`);
}

//OUTPUT:
//The sides 7, 10, and 5 form a valid triangle.

//Explanation:
// There are 3 variable represent the side of the triangle. In order to identify the valid triangle
// you need to add the two sides and if the sum is greater than the third side then its a valid else
// not valid.