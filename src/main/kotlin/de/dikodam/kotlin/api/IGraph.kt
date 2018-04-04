package de.dikodam.kotlin.api

interface IGraph {
    val vertices: Map<Int, IVertex>
    fun getNeighbors(vertex: IVertex): Set<IVertex>
    fun getNeighborsWithMove(vertex: IVertex, move: Move) : Set<IVertex>
    fun getVerticesAfterMoveSequence(start: IVertex, moves: List<Move>): Set<IVertex>

}