package Test;

public class Test {
    static int x;
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
        t1.x = 5;
        t2.x = 2;

        System.out.println(t1.x);
        System.out.println(t1.equals(t2));
        System.out.println(t1.hashCode());
        System.out.println(t2.hashCode());
    }
}
