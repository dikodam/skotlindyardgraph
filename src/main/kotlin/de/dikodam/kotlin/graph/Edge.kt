package de.dikodam.kotlin.graph

import de.dikodam.kotlin.api.EdgeType
import de.dikodam.kotlin.api.IEdge
import de.dikodam.kotlin.api.IVertex
import java.lang.IllegalArgumentException

data class Edge(val type: EdgeType, private val vertex1: IVertex, private val vertex2: IVertex) : IEdge {
    override val vertices: Set<IVertex> = setOf(vertex1, vertex2)

    override fun getOtherVertex(notThis: IVertex): IVertex =
        when (notThis) {
            vertex1 -> vertex2
            vertex2 -> vertex1
            else -> throw IllegalArgumentException("Edge doesn't reference the given vertex $notThis")
        }

}