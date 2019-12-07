package iba;

public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        test4.print(4, 5);
    }

    private void print(int n, int m) {
        int[][] arr = new int[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int i, j;
        for (int iterator = 0; iterator < n * m; iterator++) {
            i = iterator / m;
            j = iterator % m;
            //System.out.printf("iterator=%d, i=%d, j=%d\n", iterator, i, j);
            System.out.print(arr[i][j] + " ");
            if(j==m-1) System.out.println();
        }
        System.out.println();
    }
}
