package de.dikodam.kotlin.graph

import de.dikodam.kotlin.api.IGraph
import de.dikodam.kotlin.graph.dummyclasses.TestVertex
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

internal class GraphTest {

    private lateinit var tested: IGraph

    @BeforeEach
    fun setUp() {

    }

    @Test
    fun getNeighborsOf() {
    }

    @Test
    fun getNeighborsWithMove() {
    }

    @Test
    fun getVerticesAfterMoveSequence() {
    }

    @Test
    fun vertexAt() {
        tested = Graph(vertices = mapOf(42 to TestVertex(42), 12 to TestVertex(12)), edges = emptySet())

        assertAll(
            Executable { assertEquals(tested.vertexAt(42).id, 42) },
            Executable { assertEquals(tested.vertexAt(12).id, 12) }
        )
    }

    @Test
    fun getVertices() {
    }

    @Test
    fun getEdges() {
    }
}