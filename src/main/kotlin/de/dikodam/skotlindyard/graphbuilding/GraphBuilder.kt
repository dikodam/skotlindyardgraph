package de.dikodam.skotlindyard.graphbuilding

import de.dikodam.skotlindyard.api.EdgeType
import de.dikodam.skotlindyard.api.IEdge
import de.dikodam.skotlindyard.api.IVertex
import de.dikodam.skotlindyard.graph.Edge
import de.dikodam.skotlindyard.graph.Graph
import de.dikodam.skotlindyard.graph.Vertex
import java.io.File

typealias EdgeInfo = Triple<EdgeType, Int, Int>

fun buildGraph(file: File = getDefaultFile()): Graph {
    val edgeInfo = readLinesFromFile(file).map { extractEdgeInfoFromLine(it) }
    return buildGraph(edgeInfo)
}

fun buildGraph(edgeInfo: Collection<EdgeInfo>): Graph {
    val vertices = extractVertices(edgeInfo)
    val edges = buildEdges(edgeInfo, vertices).toSet()
    return Graph(vertices, edges)
}

fun extractVertices(edgeInfos: Collection<EdgeInfo>): Map<Int, IVertex> {
    return edgeInfos.flatMap { listOf(it.second, it.third) }
        .distinct()
        .map { vertexID -> Pair(vertexID, Vertex(vertexID)) }
        .toMap()
}

fun buildEdges(edgeInfos: Collection<EdgeInfo>, vertices: Map<Int, IVertex>): List<IEdge> =
    edgeInfos.map { Edge(it.first, vertices.getValue(it.second), vertices.getValue(it.third)) }
