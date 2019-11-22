package binarySearch;

import java.util.Arrays;
import java.util.Random;

public class BinarySearh {
    private int[] a;

    public BinarySearh(int len) {
        this.a = new int[len];
    }

    public void fill() {
        Random random = new Random();
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = random.nextInt(10);
        }
    }

    public void sort() {
        Arrays.sort(a);
    }

    public void print() {
        for (int i = 0; i < a.length - 1; i++) System.out.print(a[i] + " ");
        System.out.println(a[a.length - 1]);
    }

    public boolean contains(int x) {
        return binarySearch(0, a.length - 1, x);
    }

    private boolean binarySearch(int l, int r, int x) {
        if (l > r) {
            return false;
        }
        int m = (l + r) / 2;
        if (x == a[m])  return true;

        if (x > a[m])  return binarySearch(m + 1, r, x);
        else return binarySearch(l, m - 1, x);
    }
}
