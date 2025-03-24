document.addEventListener("DOMContentLoaded", function () {
    const profileButton = document.querySelector(".profile-button");
    const dropdown = document.getElementById("profile-dropdown");
    const checkoutButton = document.getElementById("checkout-btn");
    const totalAmountElement = document.getElementById("total-amount");

    function toggleDropdown(event) {
        event.stopPropagation();
        dropdown.classList.toggle("show");
    }

    profileButton.addEventListener("click", toggleDropdown);

    document.addEventListener("click", function (event) {
        if (!profileButton.contains(event.target) && !dropdown.contains(event.target)) {
            dropdown.classList.remove("show");
        }
    });

    checkoutButton.addEventListener("click", function () {
        let totalAmount = totalAmountElement.innerText.replace("$", "").trim();
        if (parseFloat(totalAmount) === 0) {
            let emptyCartModal = new bootstrap.Modal(document.getElementById("emptyCartModal"));
            emptyCartModal.show();
        } else {
            alert("Proceeding to checkout...");
        }
    });
});