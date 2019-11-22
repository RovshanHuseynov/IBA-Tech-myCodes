package warmUp._191122;

public class OddNumbers {
    public int oddNumber(int n) {
        int cnt = 0;
        int iterator = 1;
        while (cnt <= n) {
            if (iterator % 3 == 0 && iterator % 2 == 1) {
                cnt++;
            }

            if (cnt == n) {
                return iterator;
            }

            iterator++;
        }
        return -1;
    }
}
