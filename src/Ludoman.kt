package kg.geeks.game.players

import Hero

class Ludoman(health: Int, damage: Int, name: String) :
    Hero(health, damage, name, SuperAbility.DICES_THROW) {

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        val dice1 = RPGGame.random.nextInt(6) + 1
        val dice2 = RPGGame.random.nextInt(6) + 1
        if (dice1 == dice2) {
            val totalDamage = dice1 * dice2
            boss.health -= totalDamage
            println("$name threw the dice: $dice1 and $dice2. Dice numbers coincided! Boss loses $totalDamage health points.")
        } else {
            val damage = dice1 + dice2
            val randomHero = heroes.filter { it != this && it.health > 0 }.randomOrNull()
            randomHero?.let {
                it.health -= damage
                println("$name threw the dice: $dice1 and $dice2. Dice numbers didn't match! ${it.name} loses $damage health points.")
            }
        }
    }
}