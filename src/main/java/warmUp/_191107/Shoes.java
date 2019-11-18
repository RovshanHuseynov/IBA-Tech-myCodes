package warmUp._191107;

public class Shoes {
    public int solution(String S) throws IllegalAccessException {
        int interval = 0;
        int sum = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == 'R'){
                sum--;
            }
            else if(S.charAt(i) == 'L'){
                sum++;
            }
            else{
                throw new IllegalAccessException("Illegal charather is used");
            }

            if(sum == 0){
                interval++;
            }
        }

        if(sum > 0){
            throw new IllegalAccessException("number of L is more than number of R");
        }
        else if(sum < 0){
            throw new IllegalAccessException("number of R is more than number of L");
        }

        return interval;
    }
}
