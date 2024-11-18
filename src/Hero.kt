import kg.geeks.game.players.Boss

abstract class Hero(
    health: Int,
    damage: Int,
    name: String,
    val ability: SuperAbility
) : GameEntity(health, damage, name) {

    open fun attack(boss: Boss) {
        boss.health -= damage
    }

    abstract fun applySuperPower(boss: Boss, heroes: Array<Hero>)
}