package graph.graph.bfs;

import java.util.ArrayList;
import java.util.List;

public class RouteApp {
    public static void main(String[] args) {
//        Route r = new Route(5, new Point(0,4), new Point(4,0));
//        List<Point> obstacles = new ArrayList<>();
//        obstacles.add(new Point(2,0));
//        obstacles.add(new Point(2,1));
//        obstacles.add(new Point(2,2));
//        obstacles.add(new Point(2,3));
//        obstacles.add(new Point(2,4));

//        Route r = new Route(5, new Point(0,4), new Point(4,0));
//        List<Point> obstacles = new ArrayList<>();
//        obstacles.add(new Point(1,1));
//        obstacles.add(new Point(1,2));
//        obstacles.add(new Point(1,3));
//        obstacles.add(new Point(1,4));
//        obstacles.add(new Point(3,0));
//        obstacles.add(new Point(3,1));
//        obstacles.add(new Point(3,2));
//        obstacles.add(new Point(3,3));

        Route r = new Route(5, new Point(0,3), new Point(4,4));
        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(2,0));
        obstacles.add(new Point(2,1));
        obstacles.add(new Point(2,3));
        obstacles.add(new Point(2,4));

//        Route r = new Route(5, new Point(0,0), new Point(4,4));
//        List<Point> obstacles = new ArrayList<>();
//        obstacles.add(new Point(1,3));
//        obstacles.add(new Point(2,3));
//        obstacles.add(new Point(3,3));
//        obstacles.add(new Point(4,3));
//
//        obstacles.add(new Point(0,1));
//        obstacles.add(new Point(1,1));
//        obstacles.add(new Point(2,1));
//        obstacles.add(new Point(3,1));

//        Route r = new Route(5, new Point(2,0), new Point(2,4));
//        List<Point> obstacles = new ArrayList<>();
//        obstacles.add(new Point(2,3));
//        obstacles.add(new Point(3,3));
//        obstacles.add(new Point(4,3));
//        obstacles.add(new Point(1,3));

        r.setObstacles(obstacles);
        r.printTable();
        //r.searchShortestPath();
        r.goToLongestPath();
        System.out.println(r.isPathExisted());
        r.printDistances();
        r.printPath();
        r.printTable();
    }
}
