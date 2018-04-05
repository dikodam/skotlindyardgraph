package de.dikodam.skotlindyard.graph

import de.dikodam.skotlindyard.api.EdgeType
import de.dikodam.skotlindyard.api.IEdge
import de.dikodam.skotlindyard.api.IVertex

data class Vertex(override val id: Int) : IVertex {

    override lateinit var edges: Set<IEdge>

    override fun getEdgesOfType(edgeType: EdgeType): Set<IEdge> =
        edges.filter { it.type == edgeType }.toSet()

}