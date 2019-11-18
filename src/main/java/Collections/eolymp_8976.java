package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class eolymp_8976 {
    static Map<Integer, Integer> map = new HashMap<>();
    static Scanner in = new Scanner(System.in);
    static int n = in.nextInt();
    static int a[] = new int[1000];
    static int max = 0;

    public static void main(String[] args) {
        for (int i = -100; i <= 100; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            int cnt = map.get(a[i]);
            cnt++;
            max = cnt > max ? cnt : max;
            map.put(a[i], cnt);
        }

        Stack<Integer> s = new Stack<>();
        for (int i = n-1; i >=0; i--) {
            if(map.get(a[i]) == max){
                s.push(a[i]);
                map.put(a[i],0);
            }
        }

        System.out.println(max);
        int cnt = 0;
        while (!s.empty()){
            if(cnt == 0) {
                System.out.print(s.pop());
                cnt++;
            }
            else {
                System.out.printf(" %d" , s.pop());
            }
        }

        /*
        int in = 0;
        System.out.println(max);
        for (int i = 100; i >= -100; i--) {
            if (map.get(i) == max) {
                System.out.print(i);
                map.put(i, 0);
                in = i;
                break;
            }
        }

        for (int i = in - 1; i >= -100; i--) {
            if (map.get(i) == max) {
                map.put(i, 0);
                System.out.print(" " + i);
            }
        }

        System.out.println();
         */
    }
}
