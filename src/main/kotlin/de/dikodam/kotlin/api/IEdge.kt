package de.dikodam.kotlin.api

interface IEdge {
    val vertices: Set<IVertex>
    fun getOtherVertex(notThis: IVertex): IVertex
}