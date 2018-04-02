package de.dikodam.kotlin.graph

enum class EdgeType {
    TAXI, BUS, METRO, SHIP;

    fun getByCharacter(char: String): EdgeType {
        return when (char) {
            "t" -> TAXI
            "b" -> BUS
            "m" -> METRO
            "s" -> SHIP
            else -> throw IllegalArgumentException(char)
        }
    }
}