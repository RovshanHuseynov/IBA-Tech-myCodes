package warmUp._191102;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class MinimalPair {
    public static void main(String[] args) {
        MinimalPair mp = new MinimalPair();
        ArrayList<Integer> al = mp.fill(30);
        System.out.printf("Indexes are %d, %d\n", mp.findMinimum(al).x, mp.findMinimum(al).y);
        System.out.printf("Left is %d, Right is %d\n", al.get(mp.findMinimum(al).x), al.get(mp.findMinimum(al).y));
        mp.printArrayList(al);
        System.out.printf("Sum is %d\n", al.get(mp.findMinimum(al).x) + al.get(mp.findMinimum(al).y));

        IntStream.range(0, al.size()-1).mapToObj(new IntFunction<PairM>() {
            @Override
            public PairM apply(int ind) {
                return new PairM(ind, al.get(ind) + al.get(ind+1));
            }
        }).min((p1 , p2) -> p1.getSum() - p2.getSum());

        //al.stream().map();

    }

    public ArrayList<Integer> fill(int x){
        ArrayList<Integer> al = new ArrayList();
        Random r = new Random();
        for(int i=0; i<x; i++){
            al.add(r.nextInt(100));
        }
        return al;
    }

    public Pairr findMinimum(ArrayList<Integer> al){
        int min = 201;
        Pairr p = new Pairr();
        for(int i=0; i<al.size()-1; i++){
            if(al.get(i) + al.get(i+1) < min){
                min = al.get(i) + al.get(i+1);
                p.x = i;
                p.y = i+1;
            }
        }
        return p;
    }

    public void printArrayList(ArrayList<Integer> al){
        for(Integer item : al){
            System.out.printf("%d ",item);
        }
        System.out.println();
    }
}
