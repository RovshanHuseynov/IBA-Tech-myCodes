package collections.LinkedList.merge;

import collections.LinkedList.one_direction.App;
import collections.LinkedList.one_direction.LList;

public class MergeApp {
    public static void main(String[] args) {
        App l1 = new App();
        l1.add(1);
        l1.add(3);
        l1.add(5);
        l1.add(7);
        l1.add(9);
        App l2 = new App();
        l2.add(2);
        l2.add(4);
        l2.add(6);
        l2.add(10);
        l2.add(100);
        Merge app = new Merge();
        App merged = app.merge(l1.getHead(), l2.getHead());
        app.print(merged);
    }
}
