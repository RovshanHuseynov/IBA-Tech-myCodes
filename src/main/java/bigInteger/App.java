package bigInteger;

public class App {
    public static void main(String[] args) {
        Addition a = new Addition();
        System.out.println(a.add("1234", "5678"));
        System.out.println(a.add("1", "5678"));
        System.out.println(a.add("1", "999"));
    }
}
