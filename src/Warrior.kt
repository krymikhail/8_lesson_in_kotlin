import kg.geeks.game.players.Boss

class Warrior(health: Int, damage: Int, name: String) : Hero(health, damage, name, SuperAbility.CRITICAL_DAMAGE) {

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        val coefficient = RPGGame.random.nextInt(4) + 2
        val criticalDamage = coefficient * damage
        boss.health -= criticalDamage
        println("$name hit critically with damage $criticalDamage")
    }
}