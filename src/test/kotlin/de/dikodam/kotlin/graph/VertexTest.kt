package de.dikodam.kotlin.graph

import de.dikodam.kotlin.api.EdgeType.*
import de.dikodam.kotlin.graph.dummyclasses.DummyEdge
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class VertexTest {

    lateinit var tested: Vertex

    @BeforeEach
    fun setUp() {
        tested = Vertex(42)
    }

    @Test
    @DisplayName("getter ID")
    fun getId() {
        assertEquals(tested.id, 42)
    }

    @Test
    @DisplayName("edge setter and getter")
    fun getAndSetEdges() {
        val injectedEdgeSet = setOf(DummyEdge(TAXI), DummyEdge(BUS), DummyEdge(METRO), DummyEdge(SHIP))
        tested.edges = injectedEdgeSet
        assertEquals(tested.edges, injectedEdgeSet)
    }

    @Test
    @DisplayName("getter of typed edges")
    fun getEdgesOfType() {
        tested.edges = setOf(
            DummyEdge(TAXI),
            DummyEdge(TAXI),
            DummyEdge(TAXI),
            DummyEdge(BUS),
            DummyEdge(BUS),
            DummyEdge(METRO)
        )

        val result = tested.getEdgesOfType(TAXI)

        assertEquals(result.size, 3)

    }
}