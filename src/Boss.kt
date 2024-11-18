package kg.geeks.game.players

import GameEntity
import Hero
import SuperAbility

class Boss(health: Int, damage: Int, name: String) : GameEntity(health, damage, name) {
    var defence: SuperAbility? = null

    fun chooseDefence() {
        val variants = SuperAbility.values()
        defence = variants[RPGGame.random.nextInt(variants.size)]
    }

    fun attack(heroes: Array<Hero>) {
        for (hero in heroes) {
            if (hero.health > 0) {
                if (hero is Berserk && defence != SuperAbility.BLOCK_DAMAGE_REVERT) {
                    val blocked = (RPGGame.random.nextInt(2) + 1) * 5
                    hero.blockedDamage = blocked
                    hero.health -= (damage - blocked).coerceAtLeast(0)
                } else {
                    hero.health -= damage
                }
            }
        }
    }

    override fun toString(): String {
        return "BOSS ${super.toString()} defence: $defence"
    }
}