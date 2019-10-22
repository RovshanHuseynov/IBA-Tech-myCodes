import java.util.Random;
import java.util.Scanner;

public class ClassTest {

    public static void main(String[] args) {
        // print line to system standard output device (console)
        Scanner in = new Scanner(System.in);
        System.out.println(call());

    }

    public static String call(){
        Random random = new Random();
        int r1,r2,r3;
        String s = "";

        for(int i=0; i<10; i++) {
            r3 = random.nextInt(2);
            if (r3 == 0) {
                r1 = random.nextInt(26) + 65;
                s += (char)r1;
            } else if (r3 == 1) {
                r2 = random.nextInt(26) + 90;
                s += (char)r2;
            }
        }

        return s;
    }
}
