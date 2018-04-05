package de.dikodam.skotlindyard.api

interface IGraph {
    val vertices: Map<Int, IVertex>
    val edges: Set<IEdge>
    fun getNeighborsOf(vertexID: Int): Set<IVertex>
    fun getNeighborsOf(vertex: IVertex): Set<IVertex>
    fun getNeighborsAfterMove(vertexID: Int, move: Move): Set<IVertex>
    fun getNeighborsAfterMove(vertex: IVertex, move: Move): Set<IVertex>
    fun getVerticesAfterMoveSequence(startVertex: Int, moves: List<Move>): Set<IVertex>
    fun getVerticesAfterMoveSequence(startVertex: IVertex, moves: List<Move>): Set<IVertex>
    fun vertexAt(id: Int): IVertex

}