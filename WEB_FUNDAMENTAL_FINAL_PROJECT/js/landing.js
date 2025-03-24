const contentData = {
    "get-started": {
      title: "Get Started",
      description: "Begin your journey with Agri-Stock today! Explore a wide variety of fresh farm products, place your orders with ease, and enjoy hassle-free delivery. Whether you're a first-time buyer or a returning customer, our intuitive platform makes shopping simple and enjoyable."
    },
    "about-us": {
      title: "About Us",
      description: "At Agri-Stock, we strive to bring fresh agricultural products directly to your doorstep. Our platform connects farmers with consumers, ensuring high-quality produce at the best prices. We are committed to sustainability, efficiency, and creating a seamless shopping experience for everyone."
    },
    "contact-us": {
      title: "Contact Us",
      description: "Have any questions or need assistance? Our support team is here to help! Reach out to us for inquiries about orders, delivery, or partnerships. Connect with us via email, phone, or social media, and we'll ensure you have the best experience with Agri-Stock."
    }
  };

  function updateHeroContent(section) {
    if (contentData[section]) {
      document.getElementById("hero-title").textContent = contentData[section].title;
      document.getElementById("hero-description").textContent = contentData[section].description;
    }
  }

  document.querySelectorAll("#nav-links a").forEach(link => {
    link.addEventListener("click", function(event) {
      event.preventDefault();
      updateHeroContent(this.getAttribute("data-section"));
    });
  });

  document.querySelector(".btn").addEventListener("click", function(event) {
    console.log("Shop Now button clicked!");
  });
