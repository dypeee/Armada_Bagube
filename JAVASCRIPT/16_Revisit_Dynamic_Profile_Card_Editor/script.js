
let submitBtn = document.getElementById('submit');

submitBtn.addEventListener('click', function () {
    let name = document.getElementById('name').value;
    let bio = document.getElementById('bio').value;
    let image = document.getElementById('image').value;
    let background = document.getElementById('background').value;

    if (name && bio && image && background) {
        let displayName = document.querySelector('h2');
        let displayBio = document.querySelector('p');
        let displayImage = document.querySelector('img');
        let displayBackground = document.querySelector('.profile_section');

        displayName.innerText = name;
        displayBio.innerText = bio;
        displayImage.setAttribute("src", image);
        displayBackground.style.backgroundColor = background;
    } else {
        alert('Please fill up the form');
    }
});