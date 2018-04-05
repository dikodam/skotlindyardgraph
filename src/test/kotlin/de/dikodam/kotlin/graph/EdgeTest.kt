package de.dikodam.kotlin.graph

import de.dikodam.kotlin.api.EdgeType
import de.dikodam.kotlin.api.IVertex
import de.dikodam.kotlin.graph.dummyclasses.DummyVertex
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

internal class EdgeTest {

    private lateinit var tested: Edge
    private lateinit var dummyVertex1: IVertex
    private lateinit var dummyVertex2: IVertex

    @BeforeEach
    fun setUp() {
        dummyVertex1 = DummyVertex(1)
        dummyVertex2 = DummyVertex(2)
        tested = Edge(EdgeType.METRO, dummyVertex1, dummyVertex2)
    }

    @Test
    @DisplayName("getter: vertices")
    fun getVertices() {
        assertThat(tested.vertices, containsInAnyOrder(dummyVertex1, dummyVertex2))
    }

    @Test
    @DisplayName("getter: other vertex of edge")
    fun getOtherVertex() {
        assertAll(
            Executable { assertEquals(dummyVertex2, tested.getOtherVertex(dummyVertex1)) },
            Executable { assertEquals(dummyVertex1, tested.getOtherVertex(dummyVertex2)) }
        )
    }

    @Test
    @DisplayName("getter: other vertex -> exception")
    fun getOtherVertexException() {
        val dummyVertex3 = DummyVertex(3)
        assertThrows(IllegalArgumentException().javaClass, { tested.getOtherVertex(dummyVertex3) })
    }

    @Test
    @DisplayName("getter: EdgeType")
    fun getType() {
        val taxiEdge = Edge(EdgeType.TAXI, dummyVertex1, dummyVertex2)
        val busEdge = Edge(EdgeType.BUS, dummyVertex1, dummyVertex2)
        val metroEdge = Edge(EdgeType.METRO, dummyVertex1, dummyVertex2)
        val shipEdge = Edge(EdgeType.SHIP, dummyVertex1, dummyVertex2)

        assertAll(
            Executable { assertTrue(taxiEdge.type == EdgeType.TAXI) },
            Executable { assertTrue(busEdge.type == EdgeType.BUS) },
            Executable { assertTrue(metroEdge.type == EdgeType.METRO) },
            Executable { assertTrue(shipEdge.type == EdgeType.SHIP) }
        )
    }
}