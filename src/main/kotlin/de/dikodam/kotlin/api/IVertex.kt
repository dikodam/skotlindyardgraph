package de.dikodam.kotlin.api

interface IVertex {
    var edges: Set<IEdge>
    fun getEdgesOfType(edgeType: EdgeType): Set<IEdge>
}