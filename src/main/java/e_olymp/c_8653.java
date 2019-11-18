package e_olymp;

import java.util.Scanner;

public class c_8653 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res = 0;
        while (in.hasNext()) {
            String s = in.next();
            int a = in.nextInt();

            switch (s) {
                case "add":
                    res += a;
                    break;
                case "subtract":
                    res -= a;
                    break;
                case "multiply":
                    res *= a;
                    break;
            }
        }

        System.out.println(res);
    }
}
