
let player1 = {
    name: "Shrek",
    hp: 100,
    strength: 50,
    attack:function(){
        return Math.floor(Math.random() * this.strength);
    },
}
let player2 = {
    name: "Goku",
    hp: 100,
    strength: 50,
    attack:function(){
        return Math.floor(Math.random() * this.strength);
    },
}


for (let i = 1; i <= 10; i++) {
    console.log('')
    
    let shrekAttack = player1.attack();
    let gokuAttack = player2.attack();
    
    player2.hp -= shrekAttack;
    if(player2.hp<=0){
        break;
    }
    console.log(`=== Round ${i} ===`);
    console.log(`${player1.name} attacks ${player2.name} and does ${shrekAttack} damage! `)
    console.log(`${player1.name} HP: ${player1.hp} | ${player2.name} HP: ${player2.hp }`)
    console.log("")
    player1.hp -= gokuAttack;
    if(player1.hp<=0){
        break;
    }
    console.log(`${player2.name} attacks ${player1.name} and does ${gokuAttack} damage!`)
    console.log(`${player1.name} HP: ${player1.hp} | ${player2.name} HP: ${player2.hp }`)
}

if (player1.hp > player2.hp) {
    console.log(`🏆 ${player1.name} WINS the battle! 🏆`)
} else if (player1.hp < player2.hp) {
    console.log(`🏆 ${player2.name} WINS the battle! 🏆`)
} else {
    console.log(`DRAW!`)
}


