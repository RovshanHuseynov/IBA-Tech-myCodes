package warmUp._191031;

import java.util.Scanner;

public class KesrEOlymp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] sp = s.split(" ");
        long x_suret = Integer.parseInt(sp[0]);
        long x_mexrec = Integer.parseInt(sp[1]);
        long y_suret = Integer.parseInt(sp[2]);
        long y_mexrec = Integer.parseInt(sp[3]);
        long ans_suret = x_suret * y_mexrec + y_suret * x_mexrec;
        long ans_mexrec = x_mexrec * y_mexrec;
        long ebob = ebob(ans_suret , ans_mexrec);
        ans_suret = ans_suret / ebob;
        ans_mexrec = ans_mexrec / ebob;
        //System.out.println(ans_suret + " " + ans_mexrec);
        System.out.println(ans_suret + " " + ans_mexrec);
    }

    public static long ebob(long a, long b){
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;
        while(b != 0){
            a = a%b;

            long temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
}
