package e_olymp;

import java.math.BigInteger;
import java.util.Scanner;

public class c_8654 {
    public static void main(String[] args) {
        BigInteger a,b,c;
        Scanner in = new Scanner(System.in);
        a = in.nextBigInteger();
        b = in.nextBigInteger();
        c = in.nextBigInteger();

        System.out.println(a.multiply(b).mod(c));
    }
}
