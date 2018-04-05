package de.dikodam.skotlindyard.graph.dummyclasses

import de.dikodam.skotlindyard.api.EdgeType
import de.dikodam.skotlindyard.api.IEdge
import de.dikodam.skotlindyard.api.IVertex

class DummyVertex(override val id: Int) : IVertex {
    override fun addEdge(edge: IEdge): Boolean {
        return true
    }

    override fun getAllEdges(): Set<IEdge> {
        return emptySet()
    }

    override fun getEdgesOfType(edgeType: EdgeType): Set<IEdge> {
        return emptySet()
    }

    override fun getEdgeTypes(): Set<EdgeType> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
