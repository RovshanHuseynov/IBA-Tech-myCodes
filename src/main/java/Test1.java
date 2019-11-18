import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger a = in.nextBigInteger();
        BigInteger b = in.nextBigInteger();
        System.out.println(a.add(b));
    }
}
