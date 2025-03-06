function addTask(){
    //Created li element
    let newTask = document.createElement('li');
    let newNotif = document.createElement('li');
    //Fetching the input
    let inputTask = document.getElementById('taskInput').value;
    //Inserting the new task inside of the container
    let container = document.querySelector('.tasks_section ul');
    let notifContainer = document.querySelector('.notification_section ul')
    //validate the input
    if(!inputTask){
        return alert('Please Enter Task');
    }
    //Initialize value of li element
    newTask.innerHTML = `
        <p>${inputTask}</p>
        <button>Remove</button>
    `;
    //Initialize valudd of li element in Notification
    newNotif.innerHTML = `Task Added: ${inputTask}`
    
    //Adding the new task to the list
    container.appendChild(newTask);
    //Adding the new notification to the list
    notifContainer.appendChild(newNotif);

    //Remove the value once the task is added
    document.getElementById('taskInput').value="";
    
    //Delay before remove the notification
    setTimeout(()=>{
        notifContainer.removeChild(newNotif);
    },5000);

    // If the task is selected it will toggle the class selected
    newTask.addEventListener('click',function(){
        newNotif.innerHTML = `Completed: ${inputTask}`
        notifContainer.appendChild(newNotif);
        newTask.classList.toggle('selected')
        
    });
    //If the remove button press it will delete that task
    let removeBtn = newTask.querySelector('button')
    removeBtn.addEventListener('click',function(){
        container.removeChild(newTask);
        newNotif.innerHTML = `Task removed: ${inputTask}`
        notifContainer.appendChild(newNotif);

        //Delay before remove the notification
        setTimeout(()=>{
            notifContainer.removeChild(newNotif);
        },5000);
    });
}
