package warmUp._191022;

public class RandomStringGenerate {
    public String generateRandomString(int len){
        String x = "";
        for (int i = 0; i < len; i++) {
            int range = 'Z' - 'A' + 1;
            int add = ((int)(Math.random()*2)%2 == 0) ? 'A' : 'a';
            x += (char) ((Math.random() * range) + add);
        }
        return x;
    }
}
