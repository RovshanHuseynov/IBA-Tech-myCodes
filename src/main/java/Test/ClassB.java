package Test;

public class ClassB {
    public static void main(String[] args) {
        ClassA c = new ClassA();
        ClassA c5 = new ClassA();
        c.x = 5;
        System.out.println(c5.x);
        ClassB.met();
    }

    public static void met(){
        System.out.println("No instance");
    }
}
