package lesson5;

public class RandomString {
    public static void main(String[] args) {
        RandomStringGenerate g = new RandomStringGenerate();
        String s = g.generateRandomString(50);
        System.out.println(s);
        RandomStringProcess p = new RandomStringProcess();
        p.process(s);
    }
}
