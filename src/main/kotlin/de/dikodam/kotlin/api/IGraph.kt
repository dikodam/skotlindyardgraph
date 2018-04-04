package de.dikodam.kotlin.api

import de.dikodam.kotlin.graph.Move
import de.dikodam.kotlin.graph.Vertex

interface IGraph {
    fun getVerticesList(): List<Vertex>
    fun getVerticesMap(): Map<Int, Vertex>
    fun getVerticesAfterMoveSequence(start: Vertex, moves: List<Move>): Set<Vertex>

}