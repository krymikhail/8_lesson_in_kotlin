import kg.geeks.game.players.*
import kotlin.random.Random

object RPGGame {
    val random = Random.Default
    private var roundNumber = 0

    fun startGame() {
        val boss = Boss(1000, 50, "Skeleton")
        val warrior1 = Warrior(280, 10, "Knight")
        val warrior2 = Warrior(290, 15, "Ahiles")
        val magic = Magic(270, 10, "Skymag")
        val doc = Medic(250, 5, "Dumbledor", 15)
        val assistant = Medic(300, 5, "Shaman", 5)
        val berserk = Berserk(260, 10, "Guts")
        val ludoman = Ludoman(240, 10, "Rogue")

        val heroes = arrayOf(warrior1, doc, warrior2, magic, berserk, assistant, ludoman)

        showStatistics(boss, heroes)
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes)
        }
    }

    private fun playRound(boss: Boss, heroes: Array<Hero>) {
        roundNumber++
        boss.chooseDefence()
        boss.attack(heroes)
        for (hero in heroes) {
            if (hero.health > 0 && boss.health > 0 && hero.ability != boss.defence) {
                hero.attack(boss)
                hero.applySuperPower(boss, heroes)
            }
        }
        showStatistics(boss, heroes)
    }

    private fun isGameOver(boss: Boss, heroes: Array<Hero>): Boolean {
        if (boss.health <= 0) {
            println("Heroes won!!!")
            return true
        }
        if (heroes.all { it.health <= 0 }) {
            println("Boss won!!!")
            return true
        }
        return false
    }

    private fun showStatistics(boss: Boss, heroes: Array<Hero>) {
        println("ROUND $roundNumber ------------------")
        println(boss)
        heroes.forEach { println(it) }
    }
}