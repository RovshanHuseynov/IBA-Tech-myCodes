package Exception;

public class Task {
    public int[] calcSum(String origin) {
        int sum = 0, cnt = 0;
        String [] split = origin.split(" ");

        for(int i=0; i<split.length; i++) {
            try {
                sum += Integer.parseInt(split[i]);
            } catch (NumberFormatException ex) {
                cnt++;
            }
        }

        return new int [] {sum, cnt};
    }

    public boolean isZero(int x){
        return x==0 ? true : false;
    }
}
