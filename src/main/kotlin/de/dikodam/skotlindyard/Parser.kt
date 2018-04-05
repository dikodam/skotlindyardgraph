package de.dikodam.skotlindyard

import de.dikodam.skotlindyard.api.EdgeType
import de.dikodam.skotlindyard.graph.Edge
import de.dikodam.skotlindyard.graph.Graph
import de.dikodam.skotlindyard.graph.Vertex
import java.io.File
import java.util.stream.Collectors


typealias EdgeInfo = Triple<EdgeType, Int, Int>

fun buildGraph(filename: String = "scotlandYardGraph"): Graph {
    val adress = Thread.currentThread().contextClassLoader.getResource(filename).file
    val file = File(adress)
    val edgeInfos = readLinesFromFile(file).map { extractEdgeInfoFromLine(it) }
    val vertices = extractVertices(edgeInfos)
    val edges = buildEdges(edgeInfos, vertices).toSet()

    return Graph(vertices, edges)
}

fun readLinesFromFile(file: File): List<String> =
    file.bufferedReader()
        .lines()
        .collect(Collectors.toList())

fun extractEdgeInfoFromLine(line: String): EdgeInfo =
    EdgeType.values()
        .filter { line.contains(it.singleChar) }
        .map {
            val vertices = line.split(it.singleChar).map { it.toInt() }
            return EdgeInfo(it, vertices[0], vertices[1])
        }
        .first()

fun extractVertices(edgeInfos: List<EdgeInfo>): Map<Int, Vertex> =
    edgeInfos.flatMap { listOf(it.second, it.third) }
        .distinct()
        .map { Pair(it, Vertex(it)) }
        .toMap()

fun buildEdges(edgeInfos: List<EdgeInfo>, vertices: Map<Int, Vertex>): List<Edge> =
    edgeInfos.map { Edge(it.first, vertices.getValue(it.second), vertices.getValue(it.third)) }