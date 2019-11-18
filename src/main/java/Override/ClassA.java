package Override;

public class ClassA {
    public static void main(String[] args) {
        ClassA ca = new ClassA();
        ca.print();
        ca.dance();
    }

    public void print(){  // expand the access modifier during overriding a method
        System.out.println("Class A");
    }

    private void dance(){  // narrow the access modifier during overriding a method
        System.out.println("Class A");
    }
}

class ClassB {
    protected void print(){
        System.out.println("Class B");
    }

    public void dance(){
        System.out.println("Class B");
    }
}
