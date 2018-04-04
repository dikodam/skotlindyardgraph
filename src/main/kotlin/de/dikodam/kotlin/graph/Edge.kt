package de.dikodam.kotlin.graph

import de.dikodam.kotlin.api.EdgeType

data class Edge(val type: EdgeType, val vertex1: Vertex, val vertex2: Vertex)