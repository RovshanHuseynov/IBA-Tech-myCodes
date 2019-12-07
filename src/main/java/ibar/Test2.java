package iba;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.print(1, 4, 4);
    }

    public void print(int x, int n, int m) {
        int[][] arr = new int[n][m];
        int cnt=1;
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

        if (x == 1) {
            for (int i = 0; i < n; i++) {
                if(i%2 == 0) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                }
                else{
                    for (int j = m-1; j >= 0; j--) {
                        System.out.print(arr[i][j] + " ");
                    }
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < n; i++) {
                if(i%2 == 0) {
                    for (int j = m - 1; j >= 0; j--) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
                else{
                    for (int j = 0; j < m; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
