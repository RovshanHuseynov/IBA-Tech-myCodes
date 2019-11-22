package graph.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphPath {
    private final Graph g;

    public GraphPath(Graph g) {
        this.g = g;
    }

    public List<Integer> path(int from, int to) {
        List<Integer> l = new LinkedList<>();
        return null;
    }

    public boolean pathExists(int from, int to) {
//        List<Integer> l = new LinkedList<>();
        return dfs(from, to);
    }

    public boolean dfs(int from, int to) {
        System.out.printf("DFS from:%d to:%d\n", from, to);
        if (from == to) {
            System.out.println("We have reached the destination point (1st check)!");
            return true;
        }

        for (int i = 0; i < g.get(from).size(); i++) {
            if (g.get(from).get(i) == to) {
                return true;
            }

            if (dfs(g.get(from).get(i), to))
                return true;
        }
        return false;
    }
}