

document.addEventListener("DOMContentLoaded", function () {
    let cart = JSON.parse(localStorage.getItem("cart"));
    let address1 = document.getElementById("address1").value;
    let address2 = document.getElementById("address2").value;
    let city = document.getElementById("city").value;
    let state = document.getElementById("state").value;
    let zip = document.getElementById("zip").value;
    let subtotal = document.getElementById("subtotal");
    let totalAmountTxt = document.getElementById("totalAmountTxt");
    let checkoutBtn = document.getElementById("checkoutBtn");

    function calculateSubtotal(cart) {
        let totalSum = cart.reduce((sum, item) => sum + (item.totalAmount || 0), 0);
        subtotal.textContent = `$${totalSum}`;
        totalAmountTxt.textContent = `$${totalSum + 5}`;
        totalAmountTxtModal.textContent = `${totalSum + 5}`;
        // DISPLAY PRODUCT COUNT INSIDE THE CART
        let cartBtn = document.getElementById('cartbtn')
        cartBtn.innerText = ` Cart (${cart.length})`
    }

    function displayProduct(cart) {
        let productContainer = document.getElementById('cart_list');
        productContainer.innerHTML = '';

        cart.forEach((product, index) => {
            let li = document.createElement('li');
            li.innerHTML = `
            <section class="card mb-3">
                <section class="card-body d-flex align-items-between">
                    <img src="${product.image}" alt="Mixed salad dish" class="rounded"
                        style="width: 80px; height: 80px; object-fit: cover;">
                    <section class="d-flex align-items-center w-100 gap-3">
                        <header>
                            <p class="text-muted mb-1">${product.name}</p>
                            <h5 class="card-title mb-0">$${product.price}</h5>
                        </header>
                        <div class="d-flex flex-column justify-content-between">
                            <label for="quantity-${index}">Quantity</label>
                            <div class="d-flex h-50">
                                <input class="form-control quantity-input" type="number" id="quantity-${index}" 
                                    value="${product.quantity}" min="1" max="${product.stock}">
                                <div class="quantity-buttons">
                                    <button class="qty-btn btn btn-light btn-sm upBtn" type="button">▲</button>
                                    <button class="qty-btn btn btn-light btn-sm downBtn" type="button">▼</button>
                                </div>
                            </div>
                        </div>
                        <section class="total-container">
                            <label>Total Amount</label>
                            <input class="form-control py-3 total-price" type="number" value="${product.totalAmount}" disabled>
                        </section>
                        <button class="deleteBtn btn btn-danger btn-lg">x</button>
                    </section>
                </section>
            </section>
        `;

            let quantityInput = li.querySelector(`#quantity-${index}`);
            let upBtn = li.querySelector(".upBtn");
            let downBtn = li.querySelector(".downBtn");
            let totalPriceInput = li.querySelector(".total-price");
            let deleteBtn = li.querySelector(".deleteBtn");

            function updateTotalPrice() {
                let newQuantity = parseInt(quantityInput.value);
                product.quantity = newQuantity;
                product.totalAmount = product.price * newQuantity;
                totalPriceInput.value = product.totalAmount;

                cart[index] = product;
                localStorage.setItem("cart", JSON.stringify(cart));
                calculateSubtotal(cart);
            }

            // INCREMENT
            upBtn.addEventListener("click", function () {
                if (product.quantity < product.stock) {
                    quantityInput.value = ++product.quantity;
                    updateTotalPrice();
                }
            });

            // DECREMENT
            downBtn.addEventListener("click", function () {
                if (product.quantity > 1) {
                    quantityInput.value = --product.quantity;
                    updateTotalPrice();
                }
            });

            // QUANTITY INPUT CHANGE
            quantityInput.addEventListener("input", function () {
                let value = parseInt(quantityInput.value) || 1;
                if (value > product.stock) {
                    alert("Not Enough Stock");
                    value = product.stock;
                }
                if (value < 1) value = 1;
                quantityInput.value = value;
                updateTotalPrice();
            });

            // DELETE ITEM FROM CART
            deleteBtn.addEventListener("click", function () {
                if (confirm("Are you sure you want to delete this item?")) {
                    cart.splice(index, 1);
                    localStorage.setItem("cart", JSON.stringify(cart));
                    displayProduct(cart);
                }
            });

            productContainer.appendChild(li);
        });

        calculateSubtotal(cart);
    }


    // INITIAL CART DISPLAY
    displayProduct(cart);

    // SEARCH FUNCTIONALITY
    let searchInput = document.getElementById('searchInput');
    if (searchInput) {
        searchInput.addEventListener('input', function () {
            let searchValue = this.value.toLowerCase();
            let filteredProducts = cart.filter(product =>
                product.name.toLowerCase().includes(searchValue)
            );
            displayProduct(filteredProducts);
        });
    }
    // checkoutBtn.addEventListener('click', function () {
    //     let orderInfo = JSON.parse(localStorage.getItem("orderInfo")) || [];
    //     let cart = JSON.parse(localStorage.getItem("cart")) || [];
    //     let totalSum = cart.reduce((sum, item) => sum + (item.totalAmount || 0), 0);
    //     orderInfo.push({
    //         email: cart.email || "",
    //         name: cart.name,
    //         quantity: cart.quantity,
    //         category: cart.category,
    //         ratings: cart.ratings,
    //         price: cart.price,
    //         description: cart.description,
    //         image: cart.image,
    //         stock: cart.stock,
    //         unit: cart.unit,
    //         totalAmount: totalAmountTxt.textContent = `$${totalSum + 5}`,
    //         address1: address1,
    //         address2: address2,
    //         city: city,
    //         state: state,
    //         zip: zip,
    //     });
    //     localStorage.setItem("orderInfo", JSON.stringify(orderInfo));
    //     console.log(orderInfo)
    // });

    console.log(cart)

});



