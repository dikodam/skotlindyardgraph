package de.dikodam.kotlin.graph

import de.dikodam.kotlin.api.EdgeType
import de.dikodam.kotlin.api.EdgeType.*
import de.dikodam.kotlin.api.IEdge
import de.dikodam.kotlin.api.IVertex
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class VertexTest {

    lateinit var tested: Vertex

    class TestEdge(override val type: EdgeType) : IEdge {
        override fun getOtherVertex(notThis: IVertex): IVertex {
            TODO("not implemented")
        }

        override val vertices: Set<IVertex>
            get() = TODO("not implemented")

    }

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
        val injectedEdgeSet = setOf(TestEdge(TAXI), TestEdge(BUS), TestEdge(METRO), TestEdge(SHIP))
        tested.edges = injectedEdgeSet
        assertEquals(tested.edges, injectedEdgeSet)
    }

    @Test
    @DisplayName("getter of typed edges")
    fun getEdgesOfType() {
        tested.edges = setOf(
            TestEdge(TAXI),
            TestEdge(TAXI),
            TestEdge(TAXI),
            TestEdge(BUS),
            TestEdge(BUS),
            TestEdge(METRO)
        )

        val result = tested.getEdgesOfType(TAXI)

        assertEquals(result.size, 3)

    }
}