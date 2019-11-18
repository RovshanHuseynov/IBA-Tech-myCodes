package aabstract;

public class NormalClass extends AbstractClass{
    public static void main(String[] args) {
        NormalClass nc = new NormalClass();
        nc.print();
        nc.dance();
        nc.x = 10;
        System.out.println(nc.x);
    }

    void print(){
        System.out.println("Printing");
    }

    void dance(){
        System.out.println("Printing");
    }
}
