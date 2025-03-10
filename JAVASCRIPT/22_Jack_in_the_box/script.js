var mainImage = document.getElementById("mainImage");
document.getElementById("clickHere").addEventListener("click", function () {
    
    setTimeout(function () {
        var trigger = mainImage.getAttribute("data-trigger");
        mainImage.src = trigger;
    }, 1000); 
    setTimeout(function () {
        var newSrc = mainImage.getAttribute("data-frog");
        mainImage.src = newSrc;
        mainImage.style.transform = "scale(0.5)";
    }, 4700); 
    setTimeout(function () {
        var newSrc = mainImage.getAttribute("data-frog");
        mainImage.src = newSrc;
        mainImage.style.transform = "scale(0.6)";
    }, 4725); 
    setTimeout(function () {
        var newSrc = mainImage.getAttribute("data-frog");
        mainImage.src = newSrc;
        mainImage.style.transform = "scale(0.7)";
    }, 4750); 
    setTimeout(function () {
        var newSrc = mainImage.getAttribute("data-frog");
        mainImage.src = newSrc;
        mainImage.style.transform = "scale(0.8)";
    }, 4775); 
    setTimeout(function () {
        var newSrc = mainImage.getAttribute("data-frog");
        mainImage.src = newSrc;
        mainImage.style.transform = "scale(1)";
    }, 4780); 
});