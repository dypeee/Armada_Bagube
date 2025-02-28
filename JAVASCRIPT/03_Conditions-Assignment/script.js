//Task 1
let score = 89;
if (score >= 90) {
    console.log('Grade A');
} else if (score >= 80 && score <= 89) {
    console.log('Grade B');
} else if (score >= 70 && score <= 79) {
    console.log('Grade C');
} else if (score >= 60 && score <= 69) {
    console.log('Grade D');
} else {
    console.log('Grade F');
}


//Task 2
let temperature = 14;
if (temperature < 0) {
    console.log('It\'s freezing outside! Bundle up!');
} else if (temperature >= 0 && temperature <= 15) {
    console.log('It\'s cold outside. Wear a jacket.');
} else if (temperature >= 16 && temperature <= 30) {
    console.log('The weather is nice. Enjoy your day!');
} else {
    console.log('It\'s hot outside. Stay hydrated!')
}


//Task 3
const age = 15;
if (age < 13) {
    console.log("You are too young for this activity.");
} else if (age >= 13 && age <= 17) {
    console.log("You need parental permission.");
} else {
    console.log("You are eligible for this activity.");
}


//Task 4
const ageTask4 = 22;
let isMember = true;
if (ageTask4 < 12) {
    console.log('Ticket is Free')
} else if (ageTask4 >= 12 && isMember == true) {
    console.log('Ticket Costs $10')
} else if (ageTask4 >= 12 && isMember == false) {
    console.log('Ticket Costs $15')
}


//Task 5
function isLeapYear(year) {
    if (year % 4 === 0 && year % 100 !== 0 || year % 400 === 0) {
        return true;
    } else {
        return false;
    }
}
console.log(isLeapYear(2024));
console.log(isLeapYear(2002));
console.log(isLeapYear(2018));
console.log(isLeapYear(1900));
console.log(isLeapYear(2000));

