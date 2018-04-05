package de.dikodam.kotlin.graph.dummyclasses

import de.dikodam.kotlin.api.EdgeType
import de.dikodam.kotlin.api.IEdge
import de.dikodam.kotlin.api.IVertex


class DummyEdge(override val type: EdgeType) : IEdge {

    override fun getOtherVertex(notThis: IVertex): IVertex {
        TODO("not implemented")
    }

    override val vertices: Set<IVertex>
        get() = TODO("not implemented")

}
