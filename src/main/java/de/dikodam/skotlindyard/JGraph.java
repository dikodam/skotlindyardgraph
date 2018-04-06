package de.dikodam.skotlindyard;

import de.dikodam.skotlindyard.api.IEdge;
import de.dikodam.skotlindyard.api.IGraph;
import de.dikodam.skotlindyard.api.IVertex;
import de.dikodam.skotlindyard.api.Move;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JGraph implements IGraph {
    @NotNull
    @Override
    public Map<Integer, IVertex> getVertices() {
        return null;
    }

    @NotNull
    @Override
    public Set<IEdge> getEdges() {
        return null;
    }

    @NotNull
    @Override
    public Set<IVertex> getNeighborsOf(int vertexID) {
        return null;
    }

    @NotNull
    @Override
    public Set<IVertex> getNeighborsOf(@NotNull IVertex vertex) {
        return null;
    }

    @NotNull
    @Override
    public Set<IVertex> getNeighborsAfterMove(int vertexID, @NotNull Move move) {
        return null;
    }

    @NotNull
    @Override
    public Set<IVertex> getNeighborsAfterMove(@NotNull IVertex vertex, @NotNull Move move) {
        return null;
    }

    @NotNull
    @Override
    public Set<IVertex> getVerticesAfterMoveSequence(int startVertexID, @NotNull List<? extends Move> moves) {
        return null;
    }

    @NotNull
    @Override
    public Set<IVertex> getVerticesAfterMoveSequence(@NotNull IVertex startVertex, @NotNull List<? extends Move> moves) {
        return null;
    }

    @NotNull
    @Override
    public IVertex vertexAt(int id) {
        return null;
    }
}
