package interfacePackage;

public class NormalClass implements InterfaceClass{
    public static void main(String[] args) {
        NormalClass nc = new NormalClass();
        nc.print();
        System.out.println(nc.x);
    }

    @Override
    public void print(){
        System.out.println("print");
    }
}
