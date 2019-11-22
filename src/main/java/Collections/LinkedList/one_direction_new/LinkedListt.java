package collections.LinkedList.one_direction_new;

public class LinkedListt {
    LinkedListEntity head = null;

    public LinkedListEntity getHead() {
        return head;
    }

    public void add(int value) {
        LinkedListEntity newNode = new LinkedListEntity(value);
        if (head == null) {
            head = newNode;
        } else {
            LinkedListEntity current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int len() {
        LinkedListEntity current = head;
        int cnt = 0;
        while (current != null) {
            cnt++;
            current = current.next;
        }
        return cnt;
    }

    public boolean contains(int value) {
        LinkedListEntity current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(int value) {
        LinkedListEntity current = head;
        LinkedListEntity prev = null;

        while (current != null) {
            if (current.value == value) {
                if (prev == null) {
                    head = current.next;
                    break;
                } else {
                    prev.next = current.next;
                    break;
                }
            }
            prev = current;
            current = current.next;
        }
    }

    public void toStringg() {
        LinkedListEntity current = head;

        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void revert(){
        LinkedListEntity current = head;

    }
}
