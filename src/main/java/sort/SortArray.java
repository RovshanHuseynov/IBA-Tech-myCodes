package sort;

public class SortArray {
    private int[] a;

    public SortArray(int[] a) {
        this.a = a;
    }

    public int len() {
        return a.length;
    }

    public void bubbleSort() {
        for (int i = 0; i < this.len(); i++) {
            for (int j = i + 1; j < this.len(); j++) {
                if (a[i] > a[j]) {
                    int z = a[i];
                    a[i] = a[j];
                    a[j] = z;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < this.len(); i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void mergeSort() {
        mergeRecursion(0, this.len() - 1);
    }

    public void mergeRecursion(int begin, int end) {
        if (end > begin) {
            int mid;
            if ((end - begin + 1) % 2 == 0) mid = (end - begin + 1) / 2 - 1;
            else mid = (end - begin + 1) / 2;

            // division... up to 1-element array
            mergeRecursion(begin, begin + mid);
            mergeRecursion(begin + mid + 1, end);

            // memory allocation
            // copy data a->left and a->right
            int[] left = new int[begin + mid - begin + 1];
            int ind = 0;
            for (int i = begin; i <= begin + mid; i++) left[ind++] = a[i];
            int[] right = new int[end - (begin + mid + 1) + 1];
            ind = 0;
            for (int i = begin + mid + 1; i <= end; i++) right[ind++] = a[i];

            // merging
            int[] combined = combineTwoSortedArrays(left, right);

            // copy combined -> a into appropriate position
            ind = 0;
            for (int i = begin; i <= end; i++) {
                a[i] = combined[ind++];
            }
        }
    }

    public int[] combineTwoSortedArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] c = new int[n + m];
        int ind_a = 0, ind_b = 0;

        for (int i = 0; i < (n + m); i++) {
            if (ind_a > n - 1) c[i] = b[ind_b++];
            else if (ind_b > m - 1) c[i] = a[ind_a++];
            else if (a[ind_a] <= b[ind_b]) c[i] = a[ind_a++];
            else c[i] = b[ind_b++];
        }
        return c;
    }
}
