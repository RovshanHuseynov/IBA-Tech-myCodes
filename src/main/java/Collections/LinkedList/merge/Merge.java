package collections.LinkedList.merge;

import collections.LinkedList.one_direction.App;
import collections.LinkedList.one_direction.LList;

public class Merge {
    public App merge(LList head1, LList head2) {
        App merged = new App();
        while (head1 != null && head2 != null) {
            if (head1.getValue() < head2.getValue()) {
                merged.add(head1.getValue());
                head1 = head1.getNext();
            } else {
                merged.add(head2.getValue());
                head2 = head2.getNext();
            }
        }

        while (head1 != null) {
            merged.add(head1.getValue());
            head1 = head1.getNext();
        }
        while (head2 != null) {
            merged.add(head2.getValue());
            head2 = head2.getNext();
        }
        return merged;
    }

    public void print(App merged) {
        System.out.println(merged.toString());
    }
}
