document.querySelectorAll('.character_container img').forEach(image => {
    let displayContainer = document.getElementById('mainImage');
    let nameContainer = document.getElementById('mainName')
    image.addEventListener('click', function () {
        var newSrc = this.getAttribute("data-new-gif");
        var newName = this.getAttribute('data-name')
        displayContainer.src = newSrc;
        nameContainer.innerText=newName;
    });
});
