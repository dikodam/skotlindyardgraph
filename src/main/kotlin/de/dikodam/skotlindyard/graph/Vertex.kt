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

}