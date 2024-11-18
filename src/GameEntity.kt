abstract class GameEntity(
    var health: Int,
    var damage: Int,
    val name: String
) {
    override fun toString(): String {
        return "$name health: $health damage: $damage"
    }
}