package iba;

public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.print(1, 4, 6);
    }

    public void print(int x, int n, int m) {
        int[][] arr = new int[n][m];
        int cnt = 0, inc;
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

        for (int i = 0; i < n; i++) {
            cnt = (i % 2) * (m-1); // (m-1) || 0;
            inc = 1 + (i % 2) * (-2); // -1 || 1

            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][cnt] + " ");
                cnt = cnt + inc;
            }
            System.out.println();
        }
        System.out.println();
    }
}
