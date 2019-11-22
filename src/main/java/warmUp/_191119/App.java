package warmUp._191119;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        PrimeNumber np = new PrimeNumber();
        /*
        System.out.println("isPrime 8: " + np.isPrime(8));
        System.out.println("isPrime 4: " + np.isPrime(4));
        System.out.println("isPrime 7: " + np.isPrime(7));
        System.out.println("isPrime 41: " + np.isPrime(41));
        System.out.println("isPrime 111: " + np.isPrime(111));
        System.out.println("isPrime 200: " + np.isPrime(200));
        System.out.println();

        PalindromeNumber pn = new PalindromeNumber();
        System.out.println("isPalindrom 1: " + pn.isPalindrome(1));
        System.out.println("isPalindrom 11: " + pn.isPalindrome(11));
        System.out.println("isPalindrom 12: " + pn.isPalindrome(12));
        System.out.println("isPalindrom 1331: " + pn.isPalindrome(1331));
        System.out.println("isPalindrom 03330: " + pn.isPalindrome(03330));
        System.out.println("isPalindrom 1234: " + pn.isPalindrome(1234));
        System.out.println("isPalindrom 231132: " + pn.isPalindrome(231132));
        System.out.println("isPalindrom 121: " + pn.isPalindrome(121));
        System.out.println("isPalindrom 123: " + pn.isPalindrome(123));
        */

        long begin = System.currentTimeMillis();
        List<Integer> prime = new ArrayList<Integer>();

        int i = 2;
        while (prime.size() < 10000) {
            if (np.isPrime(i)) {
                prime.add(i);
            }
            i++;
        }
        long end = System.currentTimeMillis();

        System.out.println(prime.size());
        System.out.println(prime.get(prime.size() - 1));
        System.out.println(end - begin);
    }
}
