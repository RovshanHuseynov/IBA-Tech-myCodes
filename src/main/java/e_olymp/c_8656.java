package e_olymp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class c_8656 {
    public static void main(String[] args) {
        ArrayList<Pair> al = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x = in.nextInt();
            int y = in.nextInt();

            Pair p = new Pair(x,y);
            al.add(p);
        }

        al.sort((o1, o2) -> {
            if(o1.x < o2.x) return o1.x - o2.x;
            else if(o1.x == o2.x) return o2.y - o1.y;
            else return 0;
        });

        for(Pair item : al){
            System.out.println(item.x + " " + item.y);
        }
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
