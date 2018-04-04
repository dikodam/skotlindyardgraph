package de.dikodam.kotlin.graph

import de.dikodam.kotlin.api.EdgeType
import de.dikodam.kotlin.api.IEdge
import de.dikodam.kotlin.api.IVertex

data class Vertex(val id: Int) : IVertex {

    override lateinit var edges: Set<IEdge>

    override fun getEdgesOfType(edgeType: EdgeType): Set<IEdge> =
        edges.filter { it == edgeType }.toSet()

}