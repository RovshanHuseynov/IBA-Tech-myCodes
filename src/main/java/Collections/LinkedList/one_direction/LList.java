package collections.LinkedList.one_direction;

public class LList {
    private int value;
    private LList next;

    public LList(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(LList next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public LList getNext() {
        return next;
    }
}
