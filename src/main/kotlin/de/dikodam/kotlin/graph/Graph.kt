package de.dikodam.kotlin.graph

import de.dikodam.kotlin.api.*
import de.dikodam.kotlin.api.Move.*

class Graph(override val vertices: Map<Int, IVertex>, override val edges: Set<IEdge>) : IGraph {

    override fun getNeighborsOf(vertex: IVertex): Set<IVertex> {
        return vertex.edges
            .map { edge -> edge.getOtherVertex(vertex) }
            .toSet()
    }

    override fun getNeighborsAfterMove(vertex: IVertex, move: Move): Set<IVertex> {
        return vertex.edges
            .filter { edge -> edge.isAllowedByMove(move) }
            .map { edge -> edge.getOtherVertex(vertex) }
            .toSet()
    }

    override fun getVerticesAfterMoveSequence(startVertex: IVertex, moves: List<Move>): Set<IVertex> {
        var vertices = listOf(startVertex)
        for (move in moves) {
            vertices = vertices.flatMap { vertex -> getNeighborsAfterMove(vertex, move) }
        }
        return vertices.distinct().toSet()
    }

    override fun vertexAt(id: Int): IVertex =
        vertices.getValue(id)

    private fun IEdge.isAllowedByMove(move: Move): Boolean {
        return when (move) {
            TAXI -> this.type == EdgeType.TAXI
            BUS -> this.type == EdgeType.BUS
            METRO -> this.type == EdgeType.METRO
            BLACK -> true
        }
    }

}