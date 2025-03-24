// document.addEventListener("DOMContentLoaded", function () {
//     const addToCartButton = document.querySelector(".add-to-cart");
//     const modal = document.getElementById("cart-modal");
//     const modalBackdrop = document.getElementById("modal-backdrop");
//     const closeModalButton = document.querySelector(".close-btn");

//     const dropdown = document.getElementById("dropdown");
//     const profileNav = document.querySelector(".profile-nav");

//     const quantityInput = document.getElementById("quantity");
//     const increaseBtn = document.querySelector(".qty-btn.up");
//     const decreaseBtn = document.querySelector(".qty-btn.down");
//     const totalDisplay = document.querySelector(".total");

//     const mainImage = document.querySelector(".main-image");
//     const productName = document.querySelector(".product-details h2");
//     const productPrice = document.querySelector(".price-button");
//     const productDescription = document.querySelector(".description");
//     const ratingContainer = document.querySelector(".product-details p");
//     let unitPrice = parseFloat(productPrice.textContent.replace("$", "")) || 10; 

//     const thumbnails = document.querySelectorAll(".thumbnail-gallery img");

//     const similarProducts = document.querySelectorAll(".similar-products li");

//     modal.style.display = "none";
//     modalBackdrop.style.display = "none";

//     let modalTimer;

//     function showModal() {
//         modal.style.display = "flex";
//         modalBackdrop.style.display = "block";
//         modal.setAttribute("aria-hidden", "false");

//         clearTimeout(modalTimer); 
//         modalTimer = setTimeout(hideModal, 5000);
//     }

//     function hideModal() {
//         modal.style.display = "none";
//         modalBackdrop.style.display = "none";
//         modal.setAttribute("aria-hidden", "true");
//         clearTimeout(modalTimer); 
//     }

//     function toggleDropdown() {
//         dropdown.classList.toggle("show");
//     }

//     addToCartButton.addEventListener("click", showModal);
//     closeModalButton.addEventListener("click", hideModal);
//     modalBackdrop.addEventListener("click", hideModal);

//     profileNav.addEventListener("click", toggleDropdown);

//     window.addEventListener("click", function (event) {
//         if (!event.target.closest(".profile-nav")) {
//             dropdown.classList.remove("show");
//         }
//     });

//     function updateTotal() {
//         let quantity = parseInt(quantityInput.value) || 1;
//         totalDisplay.textContent = `$${(quantity * unitPrice).toFixed(2)}`;
//     }

//     updateTotal();

//     increaseBtn.addEventListener("click", function () {
//         let quantity = parseInt(quantityInput.value) || 1;
//         quantityInput.value = quantity + 1;
//         updateTotal();
//     });

//     decreaseBtn.addEventListener("click", function () {
//         let quantity = parseInt(quantityInput.value) || 1;
//         if (quantity > 1) {
//             quantityInput.value = quantity - 1;
//             updateTotal();
//         }
//     });

//     quantityInput.addEventListener("input", function () {
//         this.value = this.value === "" ? "1" : this.value;
//         updateTotal();
//     });

//     thumbnails.forEach(thumbnail => {
//         thumbnail.addEventListener("click", function () {
//             const newFilename = this.src.split('/').pop();
//             mainImage.src = mainImage.src.replace(/[^/]+$/, newFilename);
//             mainImage.alt = this.alt;
//         });
//     });

//     similarProducts.forEach(item => {
//         item.addEventListener("click", function () {
//             const newImage = item.querySelector("img").src;
//             const newName = item.querySelector("p:first-of-type").textContent.trim();
//             const newPrice = item.querySelector(".price").textContent.trim();
//             const ratingStars = item.querySelectorAll(".star-icon");
//             const newRatingText = item.querySelector(".rating-text").textContent.trim();

//             mainImage.src = newImage;
//             mainImage.alt = newName;
//             productName.textContent = newName;
//             productPrice.textContent = newPrice;

//             unitPrice = parseFloat(newPrice.replace("$", "")) || 10;
//             updateTotal();

//             updateStarRating(ratingStars, newRatingText);
//         });
//     });

//     /**
//      * @param {NodeList} stars 
//      * @param {string} ratingText 
//      */
//     function updateStarRating(stars, ratingText) {
//         ratingContainer.innerHTML = ""; 

//         stars.forEach(star => {
//             const newStar = document.createElement("i");
//             newStar.className = star.className;
//             ratingContainer.appendChild(newStar);
//         });

//         const ratingTextSpan = document.createElement("span");
//         ratingTextSpan.classList.add("rating", "num");
//         ratingTextSpan.textContent = ` ${ratingText}`;
//         ratingContainer.appendChild(ratingTextSpan);
//     }
// });



document.addEventListener("DOMContentLoaded", function () {
    let selectedProduct = JSON.parse(localStorage.getItem("selectedProduct"));
    let quantityInput = document.getElementById('quantity');
    let upBtn = document.getElementById('upBtn');
    let downBtn = document.getElementById('downBtn');
    let totalPrice = document.getElementById('totalPrice');
    let products = JSON.parse(localStorage.getItem("products"));
    let addToCartBtn = document.getElementById('addToCart');

    if (selectedProduct) {
        document.getElementById('productName').innerText = selectedProduct.name;
        document.getElementById('productImage').src = selectedProduct.image;
        document.getElementById('productPrice').innerText = `$${selectedProduct.price}`;
        document.getElementById('productDescription').innerText = selectedProduct.description;
        document.getElementById('productRatingsStar').innerHTML = '<i class="fas fa-star star-icon"></i>'.repeat(selectedProduct.ratings);
        document.getElementById('productRatings').innerText = selectedProduct.ratings;
        document.getElementById('productStocks').innerText = `Stocks: ${selectedProduct.stock}`;
        totalPrice.innerText = `$${selectedProduct.price * quantityInput.value}`;
    }

    // UPDATE TOTAL PRICE
    function updateTotalPrice() {
        totalPrice.innerText = `$${selectedProduct.price * quantityInput.value}`;
    }

    // INCREMENT
    upBtn.addEventListener("click", function () {
        if (quantityInput.value < selectedProduct.stock) {
            quantityInput.value++;
            updateTotalPrice();
        }
    });

    // DECREMENT
    downBtn.addEventListener("click", function () {
        if (quantityInput.value > 1) {
            quantityInput.value--;
            updateTotalPrice();
        }
    });

    // QUANTITY VALIDATION
    function validateQuantity() {
        let value = quantityInput.value || 1;
        if (value > selectedProduct.stock) {
            alert('Not Enough Stock');
            value = selectedProduct.stock;
        }
        if (value < 1) value = 1;
        quantityInput.value = value;
        updateTotalPrice();
    }
    quantityInput.addEventListener("input", validateQuantity);

    // DISPLAY ALL PRODUCTS
    function displayProduct(products) {
        let productContainer = document.getElementById('similar_item_container');
        let filteredProducts = products.filter(product => selectedProduct.category === product.category && selectedProduct.name != product.name)

        productContainer.innerHTML = '';
        filteredProducts.forEach(product => {

            let li = document.createElement('li');
            li.innerHTML = `
                    <img src="${product.image}" alt="Similar Item">
                    <p>${product.name}</p>
                    ${'<i class="fas fa-star star-icon"></i>'.repeat(product.ratings)}
                    <p class="price">$${product.price}</p>
            `;
            li.addEventListener("click", function () {
                localStorage.setItem("selectedProduct", JSON.stringify(product));
                location.reload();
            });
            productContainer.appendChild(li);
        });
    }

    displayProduct(products);

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

    // ADD TO CART FUNCTIONALITY
    addToCartBtn.addEventListener('click', function () {
        let cart = JSON.parse(localStorage.getItem("cart")) || [];
        // Ensure cart is an array
        if (!Array.isArray(cart)) {
            cart = [];
        }
        let users = JSON.parse(localStorage.getItem("users"));
        let quantityInput = document.getElementById('quantity');
        let currentUser = users.find(user => user.isLogin);
        if (currentUser) {
            cart.push(
                {
                    email: currentUser.email,
                    name: selectedProduct.name,
                    quantity: quantityInput.value,
                    category: selectedProduct.category,
                    ratings: selectedProduct.ratings,
                    price: selectedProduct.price,
                    description: selectedProduct.description,
                    image: selectedProduct.image,
                    stock: selectedProduct.stock,
                    unit: selectedProduct.unit,
                    totalAmount: selectedProduct.price * quantityInput.value,
                }
            )
            localStorage.setItem("cart", JSON.stringify(cart));

            window.location.href = "cart.html";
        }

    });

    // DISPLAY PRODUCT COUNT INSIDE THE CART
    let cart = JSON.parse(localStorage.getItem("cart"));
    let cartBtn = document.getElementById('cartbtn')
    cartBtn.innerText = ` Cart (${cart.length})`

    let product = JSON.parse(localStorage.getItem("products"));
    let productCount = document.getElementById('productCount')
    productCount.innerText = ` Cart (${product.length})`



});
let selectedProduct = JSON.parse(localStorage.getItem("selectedProduct"));
console.log(selectedProduct)

