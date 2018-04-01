package de.dikodam.kotlin

import de.dikodam.kotlin.graph.Graph
import java.io.File
import java.util.stream.Collectors


fun parseGraph(): Graph {
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

}

fun parseLineWithEdgeType(line: String, edgetype: String): List<String> =
    if (line.contains(edgetype)) line.split(edgetype) else emptyList()