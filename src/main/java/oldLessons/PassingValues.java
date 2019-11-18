package oldLessons;

public class PassingValues {
    public static void main(String[] args) {
        Container i = new Container(5);
        Container j = new Container(7);
        System.out.println("before");
        System.out.printf("i=%d\n", i.getValue());
        System.out.printf("k=%d\n", j.getValue());
        swap(i,j);
        System.out.println("after");
        System.out.printf("i=%d\n", i.getValue());
        System.out.printf("k=%d\n", j.getValue());
    }

    private  static void swap(Container a, Container b){
        Container temp = a;
        a = b;
        b = temp;
    }
}
