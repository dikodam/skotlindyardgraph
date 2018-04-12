package de.dikodam.skotlindyard

import de.dikodam.skotlindyard.graphbuilding.buildGraph
import de.dikodam.skotlindyard.graphbuilding.extractEdgeInfo
import de.dikodam.skotlindyard.graphbuilding.getDefaultFile

fun main(args: Array<String>) {
    val file = getDefaultFile()
    val edgeInfo = extractEdgeInfo(file)
    val graph = buildGraph(edgeInfo)
    graph.getNeighborsOf(199)
        .forEach { println(it) }
}
