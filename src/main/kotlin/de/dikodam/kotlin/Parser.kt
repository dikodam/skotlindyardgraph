package de.dikodam.kotlin

import de.dikodam.kotlin.graph.Edge
import de.dikodam.kotlin.graph.EdgeType
import de.dikodam.kotlin.graph.Graph
import de.dikodam.kotlin.graph.Vertex
import java.io.File
import java.util.stream.Collectors


fun buildGraph(): Graph {
    val fileAdress = Thread.currentThread().contextClassLoader.getResource("scotlandYardGraph").file
    val graphInput = readGraphFromFile(fileAdress)
    parseInputLines(graphInput)
    return Graph()
}

fun readGraphFromFile(fileName: String): List<String> = File(fileName)
    .bufferedReader()
    .lines()
    .collect(Collectors.toList())

fun parseInputLines(inputLines: List<String>) {
    val vertices = inputLines
        .flatMap { extractVertices(it) }
    val edges = inputLines
        .map { extractEdgeFromLine(it) }
}

fun extractEdgeFromLine(line: String): Edge {
    // TODO
}

fun extractVertices(line: String): List<Vertex> =
    EdgeType.values()
        .flatMap { edgeType -> parseLineWithEdgeType(line, edgetype = edgeType.singleChar) }
        .map { Vertex(it.toInt()) }
        .distinct()

fun parseLineWithEdgeType(line: String, edgetype: String): List<String> =
    if (line.contains(edgetype)) line.split(edgetype) else emptyList()