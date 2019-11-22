package binarySearch;

public class App {
    public static void main(String[] args) {
        BinarySearh bs = new BinarySearh(10);
        bs.fill();
        //bs.print();
        bs.sort();
        bs.print();
        System.out.println(bs.contains(1));
    }
}
