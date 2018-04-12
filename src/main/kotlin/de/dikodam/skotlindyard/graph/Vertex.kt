package de.dikodam.skotlindyard.graph

import de.dikodam.skotlindyard.api.EdgeType
import de.dikodam.skotlindyard.api.IEdge
import de.dikodam.skotlindyard.api.IVertex

data class Vertex(override val id: Int) : IVertex {

    private val edges = mutableSetOf<IEdge>()

    override fun addEdge(edge: IEdge): Boolean =
        edges.add(edge)

    override fun getAllEdges(): Set<IEdge> =
        edges.toSet()

    override fun getEdgesOfType(edgeType: EdgeType): Set<IEdge> =
        edges.filter { it.type == edgeType }.toSet()

    override fun getEdgeTypes(): Set<EdgeType> {
        return edges.map { it.type }
            .distinct()
            .toSet()
    }

    override fun toString(): String {
        return edges
            .map { "$id${it.type.singleChar}${it.getOtherVertexID(id)}" }
            .joinToString(separator = "\n")
    }
}
