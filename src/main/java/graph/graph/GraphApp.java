package graph.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nVertexes = in.nextInt();
        int nEdges = in.nextInt();
        Graph g = new Graph(nVertexes);
        for(int i=0; i<nEdges; i++){
            int from = in.nextInt();
            int to = in.nextInt();
            g.add(from, to);
        }

        GraphPath gp = new GraphPath(g);
        print(gp.showPath(2, 5));

        /*
        g.add(0, 1);
        g.add(0, 2);
        g.add(1, 3);
        g.add(1, 4);
        g.add(2, 5);
        g.add(2, 6);
        g.add(3, 4);
        g.add(3, 5);
        g.add(3, 6);
        g.add(3, 7);
        g.add(3, 9);
        g.add(8, 9);
         */
    }

    public static void print(ArrayList<Integer> l){
        for (int i = l.size() - 1; i >= 0; i--) {
            System.out.print(l.get(i) + " ");
        }
        System.out.println();
    }
}
