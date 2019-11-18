package sort;

public class MergeSort {
    public static void main(String[] args) {
        SortArray sa = new SortArray(new int []{1,3,4,2,6,8,7,5});
        //sa.bubbleSort();
        sa.mergeSort();
        sa.print();
    }
}
