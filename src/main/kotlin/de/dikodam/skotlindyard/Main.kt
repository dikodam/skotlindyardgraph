package de.dikodam.skotlindyard

fun main(args: Array<String>) {
    val graph = buildGraph()

    graph.getNeighborsOf(199)
        .forEach { println(it) }

}

