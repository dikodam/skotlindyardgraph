package de.dikodam.skotlindyard.graph

import de.dikodam.skotlindyard.api.EdgeType
import de.dikodam.skotlindyard.api.IEdge
import de.dikodam.skotlindyard.api.IVertex
import java.lang.IllegalArgumentException

data class Edge(override val type: EdgeType, private val vertex1: IVertex, private val vertex2: IVertex) : IEdge {
    override val vertices: Set<IVertex> = setOf(vertex1, vertex2)

    init {
        vertex1.addEdge(this)
        vertex2.addEdge(this)
    }

    override fun getOtherVertex(notThis: IVertex): IVertex {
        return when (notThis) {
            vertex1 -> vertex2
            vertex2 -> vertex1
            else -> throw IllegalArgumentException("Edge ${vertex1.id}$type${vertex2.id} doesn't reference the given vertex $notThis")
        }
    }

    override fun getOtherVertexID(notThisID: Int): Int {
        return when (notThisID) {
            vertex1.id -> vertex2.id
            vertex2.id -> vertex1.id
            else -> throw IllegalArgumentException("Edge ${vertex1.id}$type${vertex2.id} doesn't reference the given vertex ID $notThisID")
        }
    }

}