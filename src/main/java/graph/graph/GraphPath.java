package graph.graph;

import java.util.ArrayList;

public class GraphPath {
    private final Graph g;

    public GraphPath(Graph g) {
        this.g = g;
    }

    public ArrayList<Integer> showPath(int from, int to) {
        dfs();
        return new ArrayList<>();
    }

    private void dfs() {

    }
}