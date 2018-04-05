package de.dikodam.kotlin.api

interface IVertex {
    val id:Int
    var edges: Set<IEdge>
    fun getEdgesOfType(edgeType: EdgeType): Set<IEdge>
}