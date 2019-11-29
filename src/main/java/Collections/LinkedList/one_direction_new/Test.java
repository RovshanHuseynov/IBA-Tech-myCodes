package collections.LinkedList.one_direction_new;

public class Test {
    public static void main(String[] args) {
        LinkedListt l = new LinkedListt();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);

        reverse(l.getHead());
    }

    private static void reverse(LinkedListEntity cur) {
        if(cur == null) return;
        reverse(cur.next);
        System.out.println(cur.value);
    }
}
