package de.dikodam.skotlindyard

import de.dikodam.skotlindyard.graphbuilding.buildGraph
import de.dikodam.skotlindyard.graphbuilding.getDefaultFile

fun main(args: Array<String>) {
    val graph = buildGraph(getDefaultFile())

    graph.getNeighborsOf(199)
        .forEach { println(it) }
}

