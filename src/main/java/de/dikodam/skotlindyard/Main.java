package de.dikodam.skotlindyard;

import de.dikodam.skotlindyard.graph.Graph;
import de.dikodam.skotlindyard.graphbuilding.GraphBuilderKt;
import de.dikodam.skotlindyard.graphbuilding.ParserKt;

public class Main {
    public static void main(String[] args) {
        Graph graph = GraphBuilderKt.buildGraph(ParserKt.getDefaultFile());

        graph.getNeighborsOf(199)
            .forEach(System.out::println);
    }
}
