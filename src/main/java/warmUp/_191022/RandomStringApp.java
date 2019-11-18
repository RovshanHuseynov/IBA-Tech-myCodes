package warmUp._191022;

public class RandomStringApp {
    public static void main(String[] args) {
        RandomStringGenerate g = new RandomStringGenerate();
        String s = g.generateRandomString(50);
        System.out.println(s);
        RandomStringProcess p = new RandomStringProcess();
        p.process(s);
    }
}
