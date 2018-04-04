package de.dikodam.kotlin.api

import de.dikodam.kotlin.graph.EdgeType

interface IVertex {
    fun getEdges(): List<IEdge>
    fun getEdgesOfType(edgeType: EdgeType): List<IEdge>
}