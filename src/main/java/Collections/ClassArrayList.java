package collections;

import java.util.*;
import java.util.function.Consumer;

public class ClassArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();
        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q1 = new PriorityQueue<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayDeque<Integer> aq = new ArrayDeque<>();
        Set<String> hash_Set = new HashSet<String>();
        Set<String> tree_Set = new TreeSet<String>(hash_Set);
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "banan");
        map.put(1, "alma");
        map.put(2, "armud");
        System.out.println(map.get(2));
        map.forEach((key, value) -> System.out.print(key + " " + value + " "));
        System.out.println();

        // entrySet() key-valueleri cagirmaq ucuz isledilir
        // getKey() getValue() methodlarini cagira bilesen deye entrySet() isledirsen
        map.entrySet().stream().forEach(new Consumer<Map.Entry<Integer, String>>() {
            @Override
            public void accept(Map.Entry<Integer, String> integerStringEntry) {
                System.out.print(integerStringEntry.getKey() + " " + integerStringEntry.getValue() + " ");
            }
        });
        System.out.println();

        map.entrySet().stream().forEach(integerStringEntry -> System.out.print(integerStringEntry.getKey() + " " + integerStringEntry.getValue() + " "));
        System.out.println();

        map.entrySet().stream().forEach(System.out::print);
        System.out.println();

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::print);
        System.out.println();


    }
}