package de.dikodam.kotlin.graph

import de.dikodam.kotlin.api.*
import de.dikodam.kotlin.api.Move.*

class Graph(override val vertices: Map<Int, IVertex>, val edges: Set<IEdge>) : IGraph {

    override fun getNeighbors(vertex: IVertex): Set<IVertex> {
        return vertex.edges
            .map { edge -> edge.getOtherVertex(vertex) }
            .toSet()
    }

    override fun getNeighborsWithMove(vertex: IVertex, move: Move): Set<IVertex> {
        return vertex.edges
            .filter { edge -> edge.isAllowedByMove(move) }
            .map { edge -> edge.getOtherVertex(vertex) }
            .toSet()
    }

    override fun getVerticesAfterMoveSequence(start: IVertex, moves: List<Move>): Set<IVertex> {
        TODO("not implemented")
    }

    private fun IEdge.isAllowedByMove(move: Move): Boolean {
        return when (move) {
            TAXI -> this.type == EdgeType.TAXI
            BUS -> this.type == EdgeType.BUS
            METRO -> this.type == EdgeType.METRO
            BLACK -> true
        }
    }


}