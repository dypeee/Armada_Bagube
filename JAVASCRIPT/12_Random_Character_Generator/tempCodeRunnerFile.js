
        specialAbility:character.specialAbility[Math.floor(Math.random() * character.specialAbility.length)],
        battle(otherCharacter){
            console.log(`Character ${this.name} attacked Character ${otherCharacter.name} with Power Slash. ${otherCharacter.name}'s health dropped from ${health} to ${health-Math.floor(Math.random() * 16) + 5}.`)
        }
    }