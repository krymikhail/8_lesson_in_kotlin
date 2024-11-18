package kg.geeks.game.players

import Hero

class Berserk(health: Int, damage: Int, name: String) :
    Hero(health, damage, name, SuperAbility.BLOCK_DAMAGE_REVERT) {
    var blockedDamage: Int = 0

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        boss.health -= blockedDamage
        println("$name reverted $blockedDamage damage to boss.")
    }
}