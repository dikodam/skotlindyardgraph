package de.dikodam.skotlindyard.api

interface IVertex {
    val id: Int
    fun addEdge(edge: IEdge) : Boolean
    fun getAllEdges(): Set<IEdge>
    fun getEdgesOfType(edgeType: EdgeType): Set<IEdge>
    fun getEdgeTypes() : Set<EdgeType>
}