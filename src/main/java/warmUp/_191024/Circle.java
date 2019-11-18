package warmUp._191024;

public class Circle extends AbstractFigure {
    private int r;

    public Circle(int radius) {
        this.r = radius;
    }

    @Override
    double area() {
        return 40.0;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
