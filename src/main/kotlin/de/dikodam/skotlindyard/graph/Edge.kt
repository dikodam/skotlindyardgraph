package de.dikodam.skotlindyard.graph

import de.dikodam.skotlindyard.api.EdgeType
import de.dikodam.skotlindyard.api.IEdge
import de.dikodam.skotlindyard.api.IVertex
import java.lang.IllegalArgumentException

data class Edge(override val type: EdgeType, private val vertex1: IVertex, private val vertex2: IVertex) : IEdge {
    override val vertices: Set<IVertex> = setOf(vertex1, vertex2)

    override fun getOtherVertex(notThis: IVertex): IVertex {
        return when (notThis) {
            vertex1 -> vertex2
            vertex2 -> vertex1
            else -> throw IllegalArgumentException("Edge doesn't reference the given vertex $notThis")
        }
    }

}