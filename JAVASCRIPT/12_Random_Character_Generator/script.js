// 1. Create a Character Object
let character = {
    name: "Hero",
    health: 100,
    // Add a Random Class
    class: ["Warrior", "Mage", "Archer", "Healer", "Assassin"],
    randomClass(){
        let classes = ["Warrior", "Mage", "Archer", "Healer", "Assassin"];
        return classes[Math.floor(Math.random() * character.class.length)];
    },
    // 3. Add Randomized Health
    randomizeHealth() {
        this.health = Math.floor(Math.random() * 101) + 50;
        return this.health;
    },
    // 4. Assign a Special Ability
    specialAbility: ["Fireball", "Healing Touch", "Stealth", "Lightning Strike", "Power Slash"],
}

// 5. Create a generateCharacter() Function
function generateCharacter(inputName) {
    let names = ["Thorin", "Elara", "Zane", "Ivy", "Dante"];
    return {
        name: inputName ? inputName : names[Math.floor(Math.random() * names.length)],
        class: character.randomClass(),
        health: character.randomizeHealth(),
        specialAbility: character.specialAbility[Math.floor(Math.random() * character.specialAbility.length)],
        // 6. Battle Simulation
        attack: Math.floor(Math.random() * 16) + 5,
        battle(otherCharacter) {
            console.log(`Character ${this.name} attacked Character ${otherCharacter.name} with ${this.specialAbility}. ${otherCharacter.name}'s health dropped from ${this.health} to ${this.health - this.attack}.`)
        }
    }
}
const character1 = generateCharacter("Zane");
const character2 = generateCharacter("Elara");
character1.battle(character2);

// 7. Generate Multiple Characters
function generateMultipleCharacters(x) {
    let party = [];
    for (let i = 0; i < x; i++) {
        party.push(generateCharacter());
    }
    return party;
}
const party = generateMultipleCharacters(5);
console.dir(party);