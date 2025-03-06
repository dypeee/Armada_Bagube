let depositBtn = document.getElementById('deposit');
let withdrawBtn = document.getElementById('withdraw');

depositBtn.addEventListener('click', function () {
    let inputAmount = parseInt(document.getElementById('amount').value);
    let currentBalance = parseInt(document.getElementById('currentBalance').innerText);
    let newBalance = 0;
    currentBalance = parseInt(currentBalance)
    newBalance = currentBalance + inputAmount;
    document.getElementById('currentBalance').innerText = newBalance

    if (!inputAmount || inputAmount <= 0) {
        alert('Invalid Amount')
    } else if (inputAmount) {
        document.getElementById('currentBalance').innerText = newBalance

        document.getElementById('message').innerText = `Successfully Withdraw $${newBalance}`
        setTimeout(() => {
            document.getElementById('message').innerText = '';
        }, 1000);
    } else {
        alert('Insufficient Balance!')
    }

});

withdrawBtn.addEventListener('click', function () {
    let inputAmount = parseInt(document.getElementById('amount').value);
    let currentBalance = parseInt(document.getElementById('currentBalance').innerText);
    let newBalance = 0;
    currentBalance = parseInt(currentBalance)
    newBalance = currentBalance - inputAmount;

    if (!inputAmount || inputAmount <= 0) {
        alert('Invalid Amount')
    } else if (inputAmount <= currentBalance) {
        document.getElementById('currentBalance').innerText = newBalance
        document.getElementById('message').innerText = `Successfully Withdraw $${newBalance}`
        setTimeout(() => {
            document.getElementById('message').innerText = ""
        }, 2000);
    } else {
        alert('Insufficient Balance!')
    }


});