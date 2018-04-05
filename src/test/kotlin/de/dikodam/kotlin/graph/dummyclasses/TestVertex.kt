package de.dikodam.kotlin.graph.dummyclasses

import de.dikodam.kotlin.api.EdgeType
import de.dikodam.kotlin.api.IEdge
import de.dikodam.kotlin.api.IVertex

class TestVertex(override val id: Int) : IVertex {
    override lateinit var edges: Set<IEdge>
    override fun getEdgesOfType(edgeType: EdgeType): Set<IEdge> {
        return emptySet()
    }
}
