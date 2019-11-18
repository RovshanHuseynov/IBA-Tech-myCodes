package warmUp._191029;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortApp {
    public static void main(String[] args) {
        SortApp sa = new SortApp();
        ArrayList<Integer> arrayList = sa.fillArrayList(30);
        arrayList.forEach(s -> System.out.print(s + " "));
        ArrayList<Integer> copy = new ArrayList<>(arrayList);
        System.out.println();
        System.out.println("Odd first");
        Comparator<Integer> comparator = (i1, i2) -> {
            /*
            if(i1 % 2 == 0) return 1;
            else if(i1 % 2 == 1) return -1;
            return 0;
            */
            // return i1 - i2; // artan sira
            // return i2 - i1; // azalan sira
            return 0;
        };

        Collections.sort(copy, comparator);

        copy.forEach(s -> System.out.print(s + " "));
    }

    public ArrayList<Integer> fillArrayList(int n){
        ArrayList <Integer> arrayList = new ArrayList<Integer>();
        int range = 100;
        for(int i=0; i<n; i++){
            arrayList.add(Integer.valueOf((int)(Math.random()*100) + 1));
        }
        return arrayList;
    }
}
