package de.dikodam.skotlindyard.graphbuilding

import de.dikodam.skotlindyard.api.EdgeType
import java.io.File
import java.io.InputStream
import java.util.stream.Collectors.toList


fun extractEdgeInfo(file: File = getDefaultFile()): List<EdgeInfo> {
    return file.bufferedReader()
        .lines()
        .map(::parseLineToEdgeInfo)
        .collect(toList())
}

/**
 * @param inputStream lines will be read from this stream and parsed to edge information
 *
 * !! The client is expected to close this stream !!
 *
 * @return a list of edge information which can be built to a graph
 */
fun extractEdgeInfo(inputStream: InputStream): List<EdgeInfo> {
    return inputStream.bufferedReader()
        .lines()
        .map(::parseLineToEdgeInfo)
        .collect(toList())
}

fun parseLineToEdgeInfo(line: String): EdgeInfo {
    EdgeType.values()
        .filter { edgeType -> line.contains(edgeType.singleChar) }
        .map {
            val vertices = line.split(it.singleChar).map { it.toInt() }
            return EdgeInfo(it, vertices[0], vertices[1])
        }
        .first()
}

fun getDefaultFile(): File {
    val fileURL = Thread.currentThread().contextClassLoader.getResource("scotlandYardGraph")
    return File(fileURL.file)
}
