package de.dikodam.skotlindyard;

import de.dikodam.skotlindyard.api.EdgeType;
import de.dikodam.skotlindyard.graph.Graph;
import de.dikodam.skotlindyard.graphbuilding.GraphBuilderKt;
import de.dikodam.skotlindyard.graphbuilding.ParserKt;
import kotlin.Triple;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = ParserKt.getDefaultFile();
        List<Triple<EdgeType, Integer, Integer>> edgeInfo = ParserKt.extractEdgeInfo(file);
        Graph graph = GraphBuilderKt.buildGraph(edgeInfo);
        graph.getNeighborsOf(199)
            .forEach(System.out::println);
    }
}
