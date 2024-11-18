import kg.geeks.game.players.Boss

class Magic(health: Int, damage: Int, name: String) : Hero(health, damage, name, SuperAbility.BOOST) {

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        for (hero in heroes) {
            if (hero.health > 0 && hero != this) {
                hero.damage += 5
                println("$name boosted ${hero.name}'s damage by 5")
            }
        }
    }
}