package collections.LinkedList.one_direction;


import java.util.StringJoiner;

public class App {
    private LList head;
    private LList last;

    public static void main(String[] args) {
        App app = new App();
        app.add(1);
        app.add(2);
        app.add(3);
        app.add(4);
        app.add(5);
        app.add(6);
        app.add(7);
        //System.out.println(app.lengthRecursion1(app.head));
        //System.out.println(app.lengthRecursion2(app.head, 0));
        //System.out.println(app.containsRecursion(app.head,15));
        //System.out.println(app.containsRecursion(app.head,10));
        //app.toStringRecursion(app.head);
        //System.out.println(app.revert(app.head, ""));
        app.toStringRecursion(app.head);
    }

    public void add(int value) {
        LList item = new LList(value);
        if (head == null) {
            head = item;
            last = head;
        } else {
            last.setNext(item);
            last = item;
        }
    }

    public int get() {
        return last.getValue();
    }

    public void remove() {
    }

    public boolean contains(int value) {
        boolean isContains = false;
        LList current = head;

        while (current != null) {
            if (value == current.getValue()) isContains = true;
            current = current.getNext();
        }

        return isContains;
    }

    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        LList current = head;
        while (current != null) {
            sj.add(String.valueOf(current.getValue()));
            current = current.getNext();
        }
        return sj.toString();
    }

    public int len() {
        int cnt = 0;

        LList current = head;
        while (current != null) {
            cnt++;
            current = current.getNext();
        }
        return cnt;
    }

    public boolean containsRecursion(LList current, int value) {
        if (current == null) return false;
        if (current.getValue() == value) return true;
        return containsRecursion(current.getNext(), value);
    }

    public void toStringRecursion(LList current) {
        if (current == null) return;
        System.out.print(current.getValue() + " ");
    }

    public int lengthRecursion1(LList current) {
        if (current == null) return 0;
        return lengthRecursion1(current.getNext()) + 1;
    }

    public int lengthRecursion2(LList current, int len) {
        if (current == null) return len;
        return lengthRecursion2(current.getNext(), len + 1);
    }

    public String revert(LList current, String s) {
        if (current == null) return s;
        s += current.getValue();
        revert(current.getNext(), s);
        return s;
    }
}
