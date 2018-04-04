package de.dikodam.kotlin.api

interface IVertex {
    fun getEdges(): List<IEdge>
    fun getEdgesOfType(edgeType: EdgeType): List<IEdge>
}