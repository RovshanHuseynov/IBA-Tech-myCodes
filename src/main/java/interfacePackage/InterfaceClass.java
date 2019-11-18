package interfacePackage;

interface InterfaceClass{

    int x = 5;  // it is final automatically.
    public abstract void print();

    public static void dance(){
        System.out.println("static");
    }

    public default void jump(){
        System.out.println("default");
    }

    // only static or default methods can have body in interfacePackage
    // /other methods can not have body in interfacePackage
}