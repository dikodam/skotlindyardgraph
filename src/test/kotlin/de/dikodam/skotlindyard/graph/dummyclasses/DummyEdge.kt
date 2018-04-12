package de.dikodam.skotlindyard.graph.dummyclasses

import de.dikodam.skotlindyard.api.EdgeType
import de.dikodam.skotlindyard.api.IEdge
import de.dikodam.skotlindyard.api.IVertex


class DummyEdge(override val type: EdgeType) : IEdge {
    override fun getOtherVertex(notThis: IVertex): IVertex {
        return DummyVertex(13)
    }

    override val vertices: Set<IVertex>
        get() = TODO("not implemented")

    override fun getOtherVertexID(notThisID: Int): Int {
        return 13
    }

}
