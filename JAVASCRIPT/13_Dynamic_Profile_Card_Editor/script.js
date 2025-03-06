function updateName(){
    let name = document.getElementsByTagName("h2");
    let inputName = document.getElementById("name").value;
    name[0].innerText = inputName;
    console.log("Update Completed");
}

function updateBio(){
    let bio = document.getElementsByTagName("p");
    let inputBio = document.getElementById("bio").value;
    bio[0].innerText = inputBio;
    console.log("Update Completed");
}
function updateImage(){
    let profileImage = document.getElementById("myImage")
    let inputImage = document.getElementById("image").value;
    profileImage.setAttribute("src",inputImage)
    console.log("Update Completed");
}

function updateBackground(){
    let container = document.getElementsByClassName("profile_section");
    let inputbackground = document.getElementById("background").value;
    container[0].style.backgroundColor = inputbackground; 
}