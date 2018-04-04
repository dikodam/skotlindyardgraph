package de.dikodam.kotlin.graph

import de.dikodam.kotlin.api.IEdge
import de.dikodam.kotlin.api.IGraph
import de.dikodam.kotlin.api.IVertex
import de.dikodam.kotlin.api.Move

class Graph(override val vertices: Map<Int, IVertex>, val edges: Set<IEdge>) : IGraph {

    override fun getNeighbors(vertex: IVertex): Set<IVertex> {
        return vertex.edges
            .map { edge -> edge.getOtherVertex(vertex) }
            .toSet()
    }

    override fun getNeighborsWithMove(vertex: IVertex, move: Move): Set<IVertex> {
        return vertex.edges
            // TODO filter by move
            .filter { edge -> true }
            .map { edge -> edge.getOtherVertex(vertex) }
            .toSet()
    }

    override fun getVerticesAfterMoveSequence(start: IVertex, moves: List<Move>): Set<IVertex> {
        TODO("not implemented")
    }


}