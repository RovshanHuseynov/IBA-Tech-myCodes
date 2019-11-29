package graph.graph.bfs;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Point)) return false;
        if (this == o) return true;
        Point that = (Point) o;
        return this.x == that.x &&
                this.y == that.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
