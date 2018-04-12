package de.dikodam.skotlindyard.graph.itest

import de.dikodam.skotlindyard.api.EdgeType
import de.dikodam.skotlindyard.api.IEdge
import de.dikodam.skotlindyard.api.IVertex
import de.dikodam.skotlindyard.api.Move
import de.dikodam.skotlindyard.graph.Edge
import de.dikodam.skotlindyard.graph.Graph
import de.dikodam.skotlindyard.graph.Vertex
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import java.util.stream.IntStream
import kotlin.streams.asSequence


internal class GraphIntegrationTest {

    // GRAPH:
    // 1 t 2 t 3
    // b   s   m
    // 4 m 5 t 6

    lateinit var graph: Graph

    companion object {
        @JvmStatic
        private lateinit var vertices: Map<Int, IVertex>
        @JvmStatic
        private lateinit var edges: Set<IEdge>

        @BeforeAll
        @JvmStatic
        fun beforeClass() {
            vertices = IntStream.rangeClosed(1, 6)
                .asSequence()
                .map { Pair(it, Vertex(it)) }
                .toMap()

            edges = setOf(
                Edge(EdgeType.TAXI, vertices.getValue(1), vertices.getValue(2)),
                Edge(EdgeType.TAXI, vertices.getValue(2), vertices.getValue(3)),
                Edge(EdgeType.UNDERGROUND, vertices.getValue(3), vertices.getValue(6)),
                Edge(EdgeType.TAXI, vertices.getValue(5), vertices.getValue(6)),
                Edge(EdgeType.UNDERGROUND, vertices.getValue(5), vertices.getValue(4)),
                Edge(EdgeType.BUS, vertices.getValue(4), vertices.getValue(1)),
                Edge(EdgeType.SHIP, vertices.getValue(2), vertices.getValue(5))
            )
        }
    }

    @BeforeEach
    fun setUp() {
        graph = Graph(vertices, edges)
    }

    @Test
    @DisplayName("getNeighborsOf")
    fun getNeighborsOf() {
        val neighborsOf2 = graph.getNeighborsOf(2)
        assertThat(neighborsOf2,
            containsInAnyOrder(vertices.getValue(1),
                vertices.getValue(3),
                vertices.getValue(5))
        )
    }

    @Test
    @DisplayName("getNeighborsWithMove")
    fun getNeighborsWithMove() {
        val taxiMove = Executable {
            val neighborsAfterMove = graph.getNeighborsAfterMove(vertices.getValue(2), Move.TAXI)
            assertThat(neighborsAfterMove, containsInAnyOrder(vertices.getValue(1), vertices.getValue(3)))
        }

        val blackMove = Executable {
            val neighborsAfterMove = graph.getNeighborsAfterMove(vertices.getValue(5), Move.BLACK)
            assertThat(neighborsAfterMove,
                containsInAnyOrder(vertices.getValue(2),
                    vertices.getValue(4),
                    vertices.getValue(6)))
        }
        assertAll(taxiMove, blackMove)
    }


    @Test
    @DisplayName("leerer Test")
    fun getVerticesAfterMoveSequence() {
        TODO()
        // 2 or 3 steps
        // impossible step -> emptySet
    }

    @Test
    @DisplayName("toString")
    fun graphToString() {
        val expected = listOf("1t2", "1b4", "2t3", "2s5", "3u6", "4u5", "5t6")
        val result = graph.toString()
        expected.forEach { assertThat(result, containsString(it)) }
    }

}