package de.dikodam.skotlindyard.api

interface IVertex {
    val id:Int
    var edges: Set<IEdge>
    fun getEdgesOfType(edgeType: EdgeType): Set<IEdge>
}