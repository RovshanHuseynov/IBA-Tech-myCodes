package graph.graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final LinkedList<Integer>[] data;

    public Graph(int numberOfVertices) {
        this.data = new LinkedList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            this.data[i] = new LinkedList<>();
        }
    }

    public void add(int src, int dst) {
        data[src].add(dst);
    }

    public void remove(int src, int dst) {
        data[src].remove(new Integer(dst));
    }

    public boolean check(int src, int dst) {
        return data[src].contains(new Integer(dst));
    }

    public List<Integer> get(int src) {
        return data[src];
    }
}
