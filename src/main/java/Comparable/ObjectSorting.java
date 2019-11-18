package comparable;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ObjectSorting {
    public static void main(String[] args) {
        int arr[] = {6,5,8,10,56,7};
        Arrays.sort(arr);

        for(int item : arr){
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));

        ArrayList<Integer> al = new ArrayList<>();
        al.add(6);
        al.add(5);
        al.add(8);
        al.add(10);
        al.add(56);
        al.add(7);
        Collections.sort(al);
        al.forEach(System.out::print);
        System.out.println();
        al.forEach(x -> System.out.print(x + " "));
    }
}
