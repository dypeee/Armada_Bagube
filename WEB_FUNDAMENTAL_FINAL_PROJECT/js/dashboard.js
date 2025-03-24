// DISPLAY OBJECT USERS
let storedUsers = JSON.parse(localStorage.getItem("users")) || [];
console.log(storedUsers);

let signupBtn = document.getElementById('signupBtn');
let loginBtn = document.getElementById('loginBtn');
let logoutBtn = document.getElementById('logoutBtn');
let productContainer = document.getElementById('product_list');

// CHECK THE CURRENT USER
document.addEventListener("DOMContentLoaded", function () {
    let authContainer = document.getElementById('authContainer');
    let users = JSON.parse(localStorage.getItem("users")) || [];
    let currentUser = users.find(user => user.isLogin);

    // IF USER ISLOGIN TRUE
    if (currentUser) {
        authContainer.style.display = "none";
        showUserProfile(currentUser);
    }

    // IF USER ISLOGIN FALSE
    document.addEventListener("click", function (event) {
        if (event.target.id === "logoutBtn") {
            let users = JSON.parse(localStorage.getItem("users")) || [];
            let currentUser = users.find(user => user.isLogin);
            if (currentUser) {
                currentUser.isLogin = false;
                localStorage.setItem("users", JSON.stringify(users));
            }
            let profileContainer = document.getElementById('profileContainer');
            if (profileContainer) {
                profileContainer.remove();
            }
            authContainer.style.display = "inline";
        }
    });
});

// SHOW PROFILE FUNCTION
function showUserProfile(user) {
    let headerContainer = document.getElementById('headerContainer');
    let profileContainer = document.createElement('li');
    profileContainer.id = "profileContainer";
    profileContainer.innerHTML = `
        <div class="dropdown">
            <a class="btn btn-white dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                aria-expanded="false">
                ${user.firstName}
            </a>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" id="logoutBtn" href="#">Logout</a></li>
            </ul>
        </div>`;
    headerContainer.appendChild(profileContainer);
}

// LOGIN FUNCTION
loginBtn.addEventListener('click', function () {
    let email_login = document.getElementById('email_login').value;
    let password_login = document.getElementById('password_login').value;
    let authContainer = document.getElementById('authContainer');
    let users = JSON.parse(localStorage.getItem("users")) || [];
    let currentUser = users.find(user => user.email === email_login && user.password === password_login);
    let headerContainer = document.getElementById('headerContainer');
    if (currentUser) {
        currentUser.isLogin = true;
        localStorage.setItem("users", JSON.stringify(users));
        //Add the Profile
        if (currentUser.isLogin) {
            authContainer.style.display = "none";
            let li = document.createElement('li');
            li.innerHTML = `<div class="dropdown">
                        <a class="btn btn-white dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            ${currentUser.firstName}
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" id="logoutBtn" href="#">Logout</a></li>
                        </ul>
                    </div>`;
            li.id = "profileContainer";
            headerContainer.appendChild(li);
        }
        //Close Moodal
        let signupModal = document.getElementById('loginModal');
        let modalInstance = bootstrap.Modal.getInstance(signupModal);
        modalInstance.hide();
    } else {
        alert('Incorrect email or password');
    }
});

// SIGNUP FUNCTION
signupBtn.addEventListener('click', function () {
    let first_name = document.getElementById('first_name').value;
    let last_name = document.getElementById('last_name').value;
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    if (first_name && last_name && email && password) {
        let users = JSON.parse(localStorage.getItem("users")) || [];
        users.push({ firstName: first_name, lastName: last_name, email: email, password: password, isLogin: false });
        localStorage.setItem("users", JSON.stringify(users));
        let signupModal = document.getElementById('signupModal');
        let modalInstance = bootstrap.Modal.getInstance(signupModal);
        modalInstance.hide();
    } else {
        alert("Please fill in all fields.");
    }
});

// PRODUCTS
let products = [
    {
        name: "Mango",
        quantity: 0,
        category: "Fruits",
        ratings: 5,
        price: 50,
        unit: "kg",
        stock: 45,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/fruits/1.png"
    },
    {
        name: "Strawberry",
        quantity: 0,
        category: "Fruits",
        ratings: 4,
        price: 45,
        unit: "kg",
        stock: 54,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/fruits/2.png"
    },
    {
        name: "Rambutan",
        quantity: 0,
        category: "Fruits",
        ratings: 3,
        price: 45,
        unit: "kg",
        stock: 23,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/fruits/3.png"
    },
    {
        name: "Carrots",
        quantity: 0,
        category: "Vegetable",
        ratings: 5,
        price: 50,
        unit: "kg",
        stock: 45,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/vegetables/1.png"
    },
    {
        name: "Eggplant",
        quantity: 0,
        category: "Vegetable",
        ratings: 5,
        price: 23,
        unit: "kg",
        stock: 100,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/vegetables/2.png"
    },
    {
        name: "Beans",
        quantity: 0,
        category: "Vegetable",
        ratings: 1,
        price: 34,
        unit: "kg",
        stock: 100,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/vegetables/3.png"
    },
    {
        name: "Green Onion",
        quantity: 0,
        category: "Crops",
        ratings: 3,
        price: 34,
        unit: "kg",
        stock: 100,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/crops/1.png"
    },
    {
        name: "Rice",
        quantity: 0,
        category: "Crops",
        ratings: 4,
        price: 34,
        unit: "kg",
        stock: 100,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/crops/2.png"
    },
    {
        name: "Mung Bean",
        quantity: 0,
        category: "Crops",
        ratings: 5,
        price: 34,
        unit: "kg",
        stock: 100,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/crops/3.png"
    },
    {
        name: "Chicken Meat",
        quantity: 0,
        category: "Poultry",
        ratings: 5,
        price: 76,
        unit: "kg",
        stock: 100,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/poultry/1.png"
    },
    {
        name: "Salted Egg",
        quantity: 0,
        category: "Poultry",
        ratings: 5,
        price: 54,
        unit: "kg",
        stock: 100,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/poultry/2.png"
    },
    {
        name: "Fresh Milk",
        quantity: 0,
        category: "Poultry",
        ratings: 4,
        price: 42,
        unit: "kg",
        stock: 100,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/poultry/3.png"
    },
    {
        name: "Pig",
        quantity: 0,
        category: "Livestocks",
        ratings: 4,
        price: 42,
        unit: "kg",
        stock: 100,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/livestocks/1.png"
    },
    {
        name: "Geese",
        quantity: 0,
        category: "Livestocks",
        ratings: 4,
        price: 74,
        unit: "kg",
        stock: 100,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/livestocks/2.png"
    },
    {
        name: "Rabbit",
        quantity: 0,
        category: "Livestocks",
        ratings: 4,
        price: 42,
        unit: "kg",
        stock: 100,
        description: "Lorem ipsum dolor sit amet consectetur. Eget sit posuere enim facilisi. Pretium orci venenatis habitasse gravida nulla tincidunt iaculis. Aliquet at massa quisque libero viverra ut sed. Est vulputate est rutrum nunc nunc pellentesque ultrices pharetra. Mauris euismod sed vel quisque tincidunt suspendisse sed turpis volutpat.",
        image: "/assets/products/livestocks/3.png"
    },

];

localStorage.setItem("products", JSON.stringify(products));
let storedProducts = JSON.parse(localStorage.getItem("products")) || [];
console.log(storedProducts);

// DISPLAY ALL PRODUCTS
function displayProduct(filteredProducts) {
    let productContainer = document.getElementById('product_list');
    productContainer.innerHTML = '';

    filteredProducts.forEach(product => {
        let li = document.createElement('li');
        li.innerHTML = `
            <a href="Product_View.html" class="product-link" data-product='${JSON.stringify(product)}'>
                <img class="product_img" src="${product.image}" alt="${product.name}">
                <div class="product_wrapper">
                    <div class="product_info">
                        <h6 class="product_name">${product.name}</h6>
                        <p>
                            ${'<i class="fa-solid fa-star"></i>'.repeat(product.ratings)}
                        </p>
                        <p>${product.ratings} Ratings</p>
                    </div>
                    <div class="product_price">
                        <p>$${product.price}</p>
                    </div>
                </div>
            </a>
        `;
        li.querySelector('.product-link').addEventListener('click', function (event) {
            event.preventDefault();
            let users = JSON.parse(localStorage.getItem("users")) || [];
            let currentUser = users.find(user => user.isLogin === true);

            if (!currentUser) {
                alert("You must be logged in to view the product.");
                return;
            }
            localStorage.setItem('selectedProduct', JSON.stringify(product));
            window.location.href = "Product_View.html";
        });

        productContainer.appendChild(li);
    });
}
displayProduct(products);

//BUTTON CATEGORY
document.querySelectorAll('.categoryBtn').forEach(button => {
    button.addEventListener('click', function (event) {
        let selectedCategory = this.querySelector('img').getAttribute('data-category');
        if (selectedCategory === "All") {
            displayProduct(products);
        } else {
            let filteredProducts = products.filter(product => product.category === selectedCategory);
            displayProduct(filteredProducts);
        }
    });
});

// SEARCH FUNCTIONALITY
let searchInput = document.getElementById('searchInput');
if (searchInput) {
    searchInput.addEventListener('input', function () {
        let searchValue = this.value.toLowerCase();
        let filteredProducts = products.filter(product =>
            product.name.toLowerCase().includes(searchValue)
        );
        displayProduct(filteredProducts);
    });
}

console.log(JSON.parse(localStorage.getItem("selectedProduct")));

// DISPLAY PRODUCT COUNT INSIDE THE CART
let cart = JSON.parse(localStorage.getItem("cart"));
let cartBtn = document.getElementById('cartbtn')
cartBtn.innerText = ` Cart (${cart.length})`

// let product = JSON.parse(localStorage.getItem("products"));
// let productCount = document.getElementById('productCount')
// productCount.innerText = ` ${product.length}`

// localStorage.clear();