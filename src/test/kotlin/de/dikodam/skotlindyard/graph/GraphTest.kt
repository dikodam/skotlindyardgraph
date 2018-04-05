package de.dikodam.skotlindyard.graph

import de.dikodam.skotlindyard.api.EdgeType.BUS
import de.dikodam.skotlindyard.api.EdgeType.TAXI
import de.dikodam.skotlindyard.api.IGraph
import de.dikodam.skotlindyard.graph.dummyclasses.DummyEdge
import de.dikodam.skotlindyard.graph.dummyclasses.DummyVertex
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

internal class GraphTest {

    private lateinit var tested: IGraph
    private val dummyVerticesMap = mapOf(1 to DummyVertex(1),
        12 to DummyVertex(12),
        42 to DummyVertex(42))


    @Test
    @DisplayName("leerer Test")
    fun getNeighborsOf() {
    }

    @Test
    @DisplayName("leerer Test")
    fun getNeighborsWithMove() {
    }

    @Test
    @DisplayName("leerer Test")
    fun getVerticesAfterMoveSequence() {
    }

    @Test
    @DisplayName("getter: one specific vertex")
    fun vertexAt() {
        tested = Graph(vertices = dummyVerticesMap, edges = emptySet())

        assertAll(
            Executable { assertEquals(tested.vertexAt(42).id, 42) },
            Executable { assertEquals(tested.vertexAt(12).id, 12) }
        )
    }

    @Test
    @DisplayName("getter: vertices")
    fun getVertices() {
        val expectedVertices = dummyVerticesMap
        tested = Graph(vertices = expectedVertices, edges = emptySet())
        assertEquals(tested.vertices, expectedVertices)
    }

    @Test
    @DisplayName("getter: edges")
    fun getEdges() {
        val expectedEdges = setOf(DummyEdge(TAXI), DummyEdge(BUS))
        tested = Graph(vertices = emptyMap(), edges = expectedEdges)
        assertEquals(tested.edges, expectedEdges)
    }
}