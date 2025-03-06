let depositBtn = document.getElementById('deposit');
let withdrawBtn = document.getElementById('withdraw');

depositBtn.addEventListener('click', function () {
    let inputAmount = parseInt(document.getElementById('amount').value);
    let currentBalance = parseInt(document.getElementById('currentBalance').innerText);
    let newBalance = 0;
    let transactionList = document.createElement('li');
    let container = document.querySelector('ul');

    container.appendChild(transactionList);
    currentBalance = parseInt(currentBalance)
    newBalance = currentBalance + inputAmount;
    document.getElementById('currentBalance').innerText = newBalance

    if (!inputAmount || inputAmount <= 0) {
        alert('Invalid Amount')
    } else if (inputAmount) {
        document.getElementById('currentBalance').innerText = newBalance

        document.getElementById('message').innerText = `Successfully Deposit $${newBalance}`
        setTimeout(() => {
            document.getElementById('message').innerText = '';
        }, 3000);

        transactionList.innerText = `Deposit: $${inputAmount}`;
        transactionList.classList.add('bg-secondary-subtle','list-style-none','p-2');
        document.getElementById('amount').value="";
    } else {
        alert('Insufficient Balance!')
    }

});
let currentWithdrawAmount = 0;
   
withdrawBtn.addEventListener('click', function () {
    let inputAmount = parseInt(document.getElementById('amount').value);
    let currentBalance = parseInt(document.getElementById('currentBalance').innerText);
    let newBalance = 0;
    let dailyLimit = 500;
    
    let transactionList = document.createElement('li');
    let container = document.querySelector('ul');

    container.appendChild(transactionList);
    currentBalance = parseInt(currentBalance)
    newBalance = currentBalance - inputAmount;
    

    if (!inputAmount || inputAmount <= 0) {
        alert('Invalid Amount')
    } else if(currentWithdrawAmount >= dailyLimit || inputAmount > dailyLimit){
        alert('You Reached the daily limit of $'+ dailyLimit)
    }else if (inputAmount <= currentBalance) {
        document.getElementById('currentBalance').innerText = newBalance
        document.getElementById('message').innerText = `Successfully Withdraw $${newBalance}`
        setTimeout(() => {
            document.getElementById('message').innerText = "";
        }, 3000);
        transactionList.innerText = `Withdraw: $${inputAmount}`;
        transactionList.classList.add('bg-secondary-subtle','list-style-none','p-2');
        currentWithdrawAmount += inputAmount;
        document.getElementById('amount').value="";
    } else {
        alert('Insufficient Balance!')
    }

});