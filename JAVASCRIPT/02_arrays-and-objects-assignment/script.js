//Task 1 -----------------------------------------------------------------
let book = {
    title: 'Solo Leveling',
    author: 'Chugong',
    pages: 322,
    isRead: false,
}
console.log('----------- TASK 1 ------------')
console.log(book.title);
console.log(book['author']);
console.log(book.pages);
console.log(book['isRead']);
console.log(book.isRead = true);
book.genre = 'Fantasy';
console.log(book.genre);
console.log(book)

//Task 2 -----------------------------------------------------------------
console.log('----------- TASK 2 ------------')
let movies = [
    { title: "The Transporter", director: "Louis Leterrier & Corey Yuen", year: 2002 },
    { title: "Transporter 2", director: "Louis Leterrier", year: 2005 },
    { title: "Transporter 3", director: "Olivier Megaton", year: 2008 }
  ];
  console.log(movies[1].title);
  movies.push({ title: "The Transporter Refueled", director: "Camille Delamarre", year: 2015 });
  movies[0].year = 2023;
  console.log(movies);
  

//Task 3 -----------------------------------------------------------------
console.log('----------- TASK 3 ------------')
let student = {
    name: 'Daniel Paul C. Bagube',
    age: 22,
    subjects: ['Html', 'CSS', 'Javascript'],
}
console.log(student.subjects[0]);
student.subjects.push('Bootstrap');
console.log(student);


//Task 4 (Optional) -----------------------------------------------------
console.log('----------- TASK 4 ------------')
let recipe = {
    name: 'Spaghetti',
    ingredients: [
        { name: "Spaghetti Pasta", quantity: "400 grams" },
    ],
    isVegetarian: true,
}
recipe.ingredients.push({ name: "Tomato Paste", quantity: "2 tbsp" });
console.log(recipe.ingredients[1].name);
console.log(recipe);