package de.dikodam.skotlindyard.graph

import de.dikodam.skotlindyard.api.EdgeType.*
import de.dikodam.skotlindyard.graph.dummyclasses.DummyEdge
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class VertexTest {

    private lateinit var tested: Vertex

    @BeforeEach
    fun setUp() {
        tested = Vertex(42)
    }

    @Test
    @DisplayName("getter: ID")
    fun getId() {
        assertEquals(tested.id, 42)
    }

    @Test
    @DisplayName("getter/setter: edges")
    fun getAndSetEdges() {
        val injectedEdgeSet = setOf(DummyEdge(TAXI), DummyEdge(BUS), DummyEdge(METRO), DummyEdge(SHIP))
        injectedEdgeSet.forEach { tested.addEdge(it) }
        assertEquals(tested.getAllEdges(), injectedEdgeSet)
    }

    @Test
    @DisplayName("getter: typed edges")
    fun getEdgesOfType() {
        setOf(
            DummyEdge(TAXI),
            DummyEdge(TAXI),
            DummyEdge(TAXI),
            DummyEdge(BUS),
            DummyEdge(BUS),
            DummyEdge(METRO)
        ).forEach { edge -> tested.addEdge(edge) }


        val result = tested.getEdgesOfType(TAXI)

        assertEquals(result.size, 3)
        for (edge in result) {
            assertEquals(edge.type, TAXI)
        }
    }

    @Test
    fun getEdgeTypes() {
        tested.addEdge(DummyEdge(TAXI))
        tested.addEdge(DummyEdge(METRO))

        assertThat(tested.getEdgeTypes(), containsInAnyOrder(TAXI, METRO))
    }
}