// Task 1
let item1 = 1500;
let item2 = 2000;
let item3 = 1000;
let totalCost = item1 + item2 + item3;
console.log('The total cost of the items is: $'+ totalCost+'.');

// Task 2
let num1 = 97;
let num2 = 90;
let num3 = 89;
console.log('The average is: '+ (num1 + num2 + num3) / 3+'.');

// Task 3
let num4 = 34
if(num4 % 2 == 0){
    console.log(num4+' is an even number.');
}else{
    console.log(num4+' is an odd number.');
}

// Task 4
let originalPrice = 100;
let discountPercentage = 20;
let discountAmount = (originalPrice * discountPercentage)/100;
let discountedAmount = originalPrice - discountAmount;
console.log('The discounted price is: $'+discountedAmount+'.')

// Task 5
let finalPrice = 80;
let discountPercentageBonusTask = 20;
let originalPriceBonusTask = finalPrice/(1-discountPercentageBonusTask/100);
console.log('The original price before the discount was: $'+ originalPriceBonusTask+'.')