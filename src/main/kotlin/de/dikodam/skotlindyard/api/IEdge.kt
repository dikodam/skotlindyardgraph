package de.dikodam.skotlindyard.api

interface IEdge {
    val type: EdgeType
    val vertices: Set<IVertex>
    fun getOtherVertex(notThis: IVertex): IVertex
}