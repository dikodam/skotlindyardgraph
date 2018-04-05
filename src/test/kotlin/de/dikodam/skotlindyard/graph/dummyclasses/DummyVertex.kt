package de.dikodam.skotlindyard.graph.dummyclasses

import de.dikodam.skotlindyard.api.EdgeType
import de.dikodam.skotlindyard.api.IEdge
import de.dikodam.skotlindyard.api.IVertex

class DummyVertex(override val id: Int) : IVertex {

    override lateinit var edges: Set<IEdge>
    override fun getEdgesOfType(edgeType: EdgeType): Set<IEdge> {
        return emptySet()
    }
}
