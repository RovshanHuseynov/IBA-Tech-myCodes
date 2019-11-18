package anonymous;

class A {
    public void show(){
        System.out.println("A class");
    }
}

class B extends A {
    public void show(){
        System.out.println("B class");
    }
}

public class AnonymousClass {
    public static void main(String[] args) {
        B a = new B(){
            public void show(){
                System.out.println("asdasdsa");
            }
        };
        a.show();
    }
}
