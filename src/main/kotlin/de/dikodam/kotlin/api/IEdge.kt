package de.dikodam.kotlin.api

interface IEdge {
    val type: EdgeType
    val vertices: Set<IVertex>
    fun getOtherVertex(notThis: IVertex): IVertex
}