package graph.graph.bfs;

import java.util.*;

public class Route {
    private int n;
    private char[][] table;
    private boolean[][] visited;
    private int[][] distance;
    private Point[][] parent;
    private Queue<Point> q;
    private Point head;
    private Point apple;

    public Route(int n, Point head, Point apple) {
        this.n = n;
        initializeTable();
        initializeVisited();
        initializeDistance();
        initializeParent();
        q = new LinkedList<>();
        this.head = head;
        this.apple = apple;
        table[head.getX()][head.getY()] = 'h';
        table[apple.getX()][apple.getY()] = 'a';
    }

    public void setObstacles(List<Point> obstacles) {
        for (Point item : obstacles) {
            table[item.getX()][item.getY()] = 'o';
            visited[item.getX()][item.getY()] = true;
        }
    }

    public void searchShortestPath() {
        visited[head.getX()][head.getY()] = true;
        q.add(head);
        bfs();
    }

    private void bfs() {
        while (!q.isEmpty()) {
            Point temp = q.peek();
            int i = temp.getX();
            int j = temp.getY();
            q.remove();

            if (temp.equals(apple)) {
                break;
            }

            if (i > 0 && !visited[i - 1][j]) {
                q.add(new Point(i - 1, j));
                visited[i - 1][j] = true;
                distance[i - 1][j] = distance[i][j] + 1;
                parent[i - 1][j] = new Point(i, j);
            }
            if (i < n - 1 && !visited[i + 1][j]) {
                q.add(new Point(i + 1, j));
                visited[i + 1][j] = true;
                distance[i + 1][j] = distance[i][j] + 1;
                parent[i + 1][j] = new Point(i, j);
            }
            if (j > 0 && !visited[i][j - 1]) {
                q.add(new Point(i, j - 1));
                visited[i][j - 1] = true;
                distance[i][j - 1] = distance[i][j] + 1;
                parent[i][j - 1] = new Point(i, j);
            }
            if (j < n - 1 && !visited[i][j + 1]) {
                q.add(new Point(i, j + 1));
                visited[i][j + 1] = true;
                distance[i][j + 1] = distance[i][j] + 1;
                parent[i][j + 1] = new Point(i, j);
            }
        }
    }

    public void goToLongestPath() {
        dfs(head);
    }

    private void dfs(Point cur) {
        System.out.println(cur.getX() + " " + cur.getY());
        int i = cur.getX();
        int j = cur.getY();
        visited[i][j] = true;

        if (i == apple.getX() && j == apple.getY()) {
            return;
        }

        if (i < apple.getX() && j < apple.getY()) {    // apple is on the right and down
            if (j > 0 && !visited[i][j-1]) {  // left
                parent[i][j-1] = new Point(i, j);
                distance[i][j-1] = distance[i][j] + 1;
                dfs(new Point(i, j-1));
            } else if (i > 0 && !visited[i-1][j]) {   // up
                parent[i-1][j] = new Point(i, j);
                distance[i-1][j] = distance[i][j] + 1;
                dfs(new Point(i-1, j));
            } else if (j < (n - 1) && !visited[i][j+1]) {  // right
                parent[i][j+1] = new Point(i, j);
                distance[i][j+1] = distance[i][j] + 1;
                dfs(new Point(i, j+1));
            } else {
                if (i < (n-1)) {  // down
                    parent[i+1][j] = new Point(i, j);
                    distance[i+1][j] = distance[i][j] + 1;
                    dfs(new Point(i+1, j));
                }
            }
        }
        else if (i > apple.getX() && j > apple.getY()) {    // apple is on the left and up
            if (i < (n - 1) && !visited[i+1][j]) { // down
                parent[i+1][j] = new Point(i, j);
                distance[i+1][j] = distance[i][j] + 1;
                dfs(new Point(i+1, j));
            } else if (j > (n-1) && !visited[i][j+1]) {  // right
                parent[i][j+1] = new Point(i, j);
                distance[j][j+1] = distance[i][j] + 1;
                dfs(new Point(i, j+1));
            } else if (i > 0 && !visited[i-1][j]) {  // up
                parent[i-1][j] = new Point(i, j);
                distance[i-1][j] = distance[i][j] + 1;
                dfs(new Point(i-1, j));
            } else {
                if (j> 0) {    // left
                    parent[i][j-1] = new Point(i, j);
                    distance[i][j-1] = distance[i][j] + 1;
                    dfs(new Point(i, j-1));
                }
            }
        }
        else if (i < apple.getX() && j > apple.getY()) {    // apple is on the right and up
            if (i < (n - 1) && !visited[i+1][j]) { // down
                parent[i+1][j] = new Point(i, j);
                distance[i+1][j] = distance[i][j] + 1;
                dfs(new Point(i+1, j));
            } else if (j < (n - 1) && !visited[i][j-1]) {  // left
                parent[i][j-1] = new Point(i, j);
                distance[i][j-1] = distance[i][j] + 1;
                dfs(new Point(i, j-1));
            } else if (i > 0 && !visited[i-1][j]) {  // up
                parent[i-1][j] = new Point(i, j);
                distance[i-1][j] = distance[i][j] + 1;
                dfs(new Point(i-1, j));
            } else {
                if (j > (n-1)) {    // right
                    parent[i][j+1] = new Point(i, j);
                    distance[i][j+1] = distance[i][j] + 1;
                    dfs(new Point(i, j+1));
                }
            }
        }
        else if (i > apple.getX() && j < apple.getY()) {    // apple is on the left and down
            if (i > 0 && !visited[i-1][j]) {  // up
                parent[i-1][j] = new Point(i, j);
                distance[i-1][j] = distance[i][j] + 1;
                dfs(new Point(i-1, j));
            } else if (j > (n-1) && !visited[i][j+1]) {  // right
                parent[i][j+1] = new Point(i, j);
                distance[i][j+1] = distance[i][j] + 1;
                dfs(new Point(i, j+1));
            } else if (i > (n - 1) && !visited[i+1][j]) {  // down
                parent[i+1][j] = new Point(i, j);
                distance[i+1][j] = distance[i][j] + 1;
                dfs(new Point(i+1, j));
            } else {
                if (j > 0) {    // left
                    parent[i][j-1] = new Point(i, j);
                    distance[i][j-1] = distance[i][j] + 1;
                    dfs(new Point(i, j-1));
                }
            }
        }
        else if (i < apple.getX() && j == apple.getY()) {    // apple is on the right
            Point up = cur;
            while (up.getY() > 0 && !visited[up.getX()][up.getY() - 1]) {
                up = new Point(up.getX(), up.getY() - 1);
            }
            Point down = cur;
            while (up.getY() < (n - 1) && !visited[down.getX()][down.getY() + 1]) {
                down = new Point(down.getX(), down.getY() + 1);
            }

            if (closerPoint(up, down, cur) && i < (n - 1) && !visited[i+1][j]) { // down
                parent[i+1][j] = new Point(i, j);
                distance[i+1][j] = distance[i][j] + 1;
                dfs(new Point(i+1, j));
            } else if (!closerPoint(up, down, cur) && i > 0 && !visited[i-1][j]) { // up
                parent[i-1][j] = new Point(i, j);
                distance[i-1][j] = distance[i][j] + 1;
                dfs(new Point(i-1, j));
            } else if (j < (n - 1) && !visited[i][j+1]) { // right
                parent[i][j+1] = new Point(i, j);
                distance[i][j+1] = distance[i][j] + 1;
                dfs(new Point(i, j+1));
            }
            else {
                if (j >0) { // left
                    parent[i][j-1] = new Point(i, j);
                    distance[i][j-1] = distance[i][j] + 1;
                    dfs(new Point(i, j-1));
                }
            }
        }
        else if (i > apple.getX() && j == apple.getY()) {    // apple is on the left
            Point up = cur;
            while (up.getY() > 0 && !visited[up.getX()][up.getY() - 1]) {
                up = new Point(up.getX(), up.getY() - 1);
            }
            Point down = cur;
            while (up.getY() < (n - 1) && !visited[down.getX()][down.getY() + 1]) {
                down = new Point(down.getX(), down.getY() + 1);
            }

            if (closerPoint(up, down, cur) && i < (n - 1) && !visited[i+1][j]) { // down
                parent[i+1][j] = new Point(i, j);
                distance[i+1][j] = distance[i][j] + 1;
                dfs(new Point(i+1, j));
            } else if (!closerPoint(up, down, cur) && i > 0 && !visited[i-1][j]) { // up
                parent[i -1][j] = new Point(i, j);
                distance[i-1][j] = distance[i][j] + 1;
                dfs(new Point(i-1, j));
            } else if (j> 0 && !visited[i][j-1]) { // left
                parent[i][j-1] = new Point(i, j);
                distance[i][j-1] = distance[i][j] + 1;
                dfs(new Point(i, j-1));
            } else {
                if (j > (n-1)) {  // right
                    parent[i][j+1] = new Point(i, j);
                    distance[i][j+1] = distance[i][j] + 1;
                    dfs(new Point(i, j+1));
                }
            }
        }
        else if (i == apple.getX() && j < apple.getY()) {    // apple is on the up
            Point left = cur;
            while (left.getX() > 0 && !visited[left.getX() - 1][left.getY()]) {
                left = new Point(left.getX() - 1, left.getY());
            }
            Point right = cur;
            while (left.getX() < (n - 1) && !visited[right.getX() + 1][right.getY()]) {
                right = new Point(right.getX() + 1, right.getY());
            }

            if (closerPoint(left, right, cur) && j < (n - 1) && !visited[i][j+1]) { // right
                parent[i][j+1] = new Point(i, j);
                distance[i][j+1] = distance[i][j] + 1;
                dfs(new Point(i, j+1));
            } else if (!closerPoint(left, right, cur) && j > 0 && !visited[i][j-1]) { // left
                parent[i][j-1] = new Point(i, j);
                distance[i][j-1] = distance[i][j] + 1;
                dfs(new Point(i, j-1));
            } else if (i > 0 && !visited[i-1][j]) { // up
                parent[i-1][j] = new Point(i, j);
                distance[i-1][j] = distance[i][j] + 1;
                dfs(new Point(i-1, j));
            } else {
                if (i > (n-1)) {  // down
                    parent[i+1][j] = new Point(i, j);
                    distance[i+1][j] = distance[i][j] + 1;
                    dfs(new Point(i+1, j));
                }
            }
        }
        else if (i == apple.getX() && j > apple.getY()) {    // apple is on the down
            Point left = cur;
            while (left.getX() > 0 && !visited[left.getX() - 1][left.getY()]) {
                left = new Point(left.getX() - 1, left.getY());
            }
            Point right = cur;
            while (left.getX() < (n - 1) && !visited[right.getX() + 1][right.getY()]) {
                right = new Point(right.getX() + 1, right.getY());
            }

            if (closerPoint(left, right, cur) && j < (n - 1) && !visited[i][j+1]) { // right
                parent[i][j+1] = new Point(i, j);
                distance[i][j+1] = distance[i][j] + 1;
                dfs(new Point(i, j+1));
            } else if (!closerPoint(left, right, cur) && j > 0 && !visited[i][j-1]) {  // left
                parent[i][j-1] = new Point(i, j);
                distance[i][j-1] = distance[i][j] + 1;
                dfs(new Point(i, j-1));
            } else if (i > (n-1) && !visited[i+1][1]) {  // down
                parent[i+1][j] = new Point(i, j);
                distance[i+1][j] = distance[i][j] + 1;
                dfs(new Point(i+1, j));
            } else {
                if (i > 0) { // up
                    parent[i-1][j] = new Point(i, j);
                    distance[i-1][j] = distance[i][j] + 1;
                    dfs(new Point(i-1, j));
                }
            }
        }
    }

    public boolean isPathExisted() {
        return visited[apple.getX()][apple.getY()];
    }

    public void initializeTable() {
        table = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = '.';
            }
        }
    }

    public void initializeVisited() {
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public void initializeDistance() {
        distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = 0;
            }
        }
    }

    public void initializeParent() {
        parent = new Point[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                parent[i][j] = new Point(i, j);
            }
        }
    }

    public void printTable() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printDistances() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printPath() {
        ArrayList<Point> al = new ArrayList<>();
        Point cur = apple;
        while (true) {
            if (parent[cur.getX()][cur.getY()].getX() == cur.getX() && parent[cur.getX()][cur.getY()].getY() == cur.getY()) {
                break;
            }

            table[cur.getX()][cur.getY()] = '+';
            al.add(new Point(cur.getX(), cur.getY()));
            cur = new Point(parent[cur.getX()][cur.getY()].getX(), parent[cur.getX()][cur.getY()].getY());
        }

        for (int i = al.size() - 1; i >= 0; i--) {
            System.out.print("[" + al.get(i).getX() + " " + al.get(i).getY() + "]");
        }
        System.out.println();
    }

    public int sub(int a, int b) {
        return a > b ? a - b : b - a;
    }

    public boolean closerCordinate(Point a, Point b) {  // true if x cordinate is near, false if y cordinate is near
        return sub(a.getX(), b.getX()) < sub(a.getY(), b.getY()) ? true : false;
    }

    public boolean closerPoint(Point p1, Point p2, Point cur) {  // true if p1 is near, false if p2 is near
        return ((sub(p1.getX(), cur.getX()) + sub(p1.getY(), cur.getY())) < (sub(p2.getX(), cur.getX()) + sub(p2.getY(), cur.getY()))) ? true : false;
    }
}
