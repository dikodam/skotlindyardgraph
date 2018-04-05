package de.dikodam.skotlindyard.graphbuilding

import de.dikodam.skotlindyard.api.EdgeType
import java.io.File
import java.util.stream.Collectors


fun readLinesFromFile(file: File): List<String> {
    return file.bufferedReader()
        .lines()
        .collect(Collectors.toList())
}

fun extractEdgeInfoFromLine(line: String): EdgeInfo {
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
