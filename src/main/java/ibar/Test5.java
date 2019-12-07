package ibar;

public class Test5 {
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        test5.build("LR", 3, 6);
    }

    private void build(String direction, int n, int m) {
        int[][] arr = new int[n][m];
        int d = direction.equals("LR") ? 0 : 1;
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
            j = (iterator % m);
            j = (m - 1) * (i % 2) + j - (2 * j) * (i % 2);
            j = (m - 1) * (d % 2) + j - (2 * j) * (d % 2);
            System.out.printf("%d ", arr[i][j]);
            //System.out.printf("iterator=%d, i=%d, j=%d\n", iterator, i, j);
            //if ((iterator % m) == (m - 1)) System.out.println();
        }
    }
}
