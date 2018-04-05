package de.dikodam.kotlin.api

interface IGraph {
    val vertices: Map<Int, IVertex>
    fun getNeighborsOf(vertex: IVertex): Set<IVertex>
    fun getNeighborsWithMove(vertex: IVertex, move: Move) : Set<IVertex>
    fun getVerticesAfterMoveSequence(startVertex: IVertex, moves: List<Move>): Set<IVertex>

}