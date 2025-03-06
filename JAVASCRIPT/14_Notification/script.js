function showNotification() {
    // I create an element called li
    let newList = document.createElement('li');
    // Added a value of the element using innerHTML
    newList.innerHTML = `
        <p class="message">You have a new message</p>
        <button class="close-btn">X</button>`;
    // I called the parent container
    let container = document.getElementById('container');
    //Append the List of notification inside of the container
    container.appendChild(newList);

    //It will remove the child automatically after 5 sec
    setTimeout(()=>{
        container.removeChild(newList);
    },5000);
}

function remove(){
     //I select the button of that specific list
     let closeBtn = newList.querySelector('.close-btn');
     // If I clicked the close button it will remove that specific list
     closeBtn.addEventListener('click', function () {
         container.removeChild(newList);
     });
}


