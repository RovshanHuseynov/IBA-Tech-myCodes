package collections.LinkedList.one_direction_new;

public class LinkedListtApp {
    public static void main(String[] args) {
        LinkedListt l = new LinkedListt();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        System.out.println(l.len());
        System.out.println(l.getHead().value);
        System.out.println(l.contains(4));
        System.out.println(l.contains(10));
        l.toStringg();
        l.remove(4);
        l.toStringg();
    }
}
