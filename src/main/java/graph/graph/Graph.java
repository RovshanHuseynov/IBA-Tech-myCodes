package graph.graph;

import java.util.ArrayList;

public class Graph {
    private final ArrayList[] data;
    private final int [] parent;

    public Graph(int numberOfVertices) {
        this.data = new ArrayList[numberOfVertices];
        this.parent = new int[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            this.data[i] = new ArrayList<>();
            this.parent[i] = i;
        }
    }

    public void add(int src, int dst) {
        data[src].add(dst);
        parent[dst] = src;
    }

    public void remove(int src, int dst) {
        data[src].remove(new Integer(dst));
    }

    public boolean check(int src, int dst) {
        return data[src].contains(new Integer(dst));
    }

    public ArrayList<Integer> get(int src) {
        return data[src];
    }

    public void setParent(int from, int to){
        parent[to] = from;
    }

    public int getParent(int node){
        return parent[node];
    }

    public int len() {
        return parent.length;
    }
}
