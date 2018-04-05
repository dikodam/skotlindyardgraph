package de.dikodam.skotlindyard.graph

import de.dikodam.skotlindyard.api.*
import de.dikodam.skotlindyard.api.Move.*

class Graph(override val vertices: Map<Int, IVertex>, override val edges: Set<IEdge>) : IGraph {

    override fun getNeighborsOf(vertex: IVertex): Set<IVertex> {
        return vertex.getAllEdges()
            .map { edge -> edge.getOtherVertex(vertex) }
            .toSet()
    }

    override fun getNeighborsOf(vertexID: Int): Set<IVertex> =
        getNeighborsOf(vertices.getValue(vertexID))

    override fun getNeighborsAfterMove(vertex: IVertex, move: Move): Set<IVertex> {
        return vertex.getAllEdges()
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