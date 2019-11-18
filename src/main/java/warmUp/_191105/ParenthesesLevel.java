package warmUp._191105;

import java.util.ArrayList;

public class ParenthesesLevel {
    public Result calc(String origin) throws IllegalAccessException {
        ArrayList<String> al = new ArrayList<>();
        String storeLetters = "";
        String storeOthers = "";
        int cntOpen = 0, cntClose = 0, max = 0;

        for(int i=0; i<origin.length(); i++){
            if(origin.charAt(i) == '('){
                cntOpen++;
            }
            else if(origin.charAt(i) == ')'){
                cntClose++;

                max = cntOpen > max ? cntOpen : max;
                cntOpen--;
                cntClose--;
            }
            else if(origin.charAt(i) >= 'a' && origin.charAt(i) <= 'z'){
                storeLetters += origin.charAt(i);
                if(i == origin.length()-1){
                    al.add(storeLetters);
                }
                else if(!(origin.charAt(i+1) >= 'a' && origin.charAt(i+1) <= 'z')){
                    al.add(storeLetters);
                    storeLetters = "";
                }
            }
            else{
                storeOthers += origin.charAt(i);
                if(i == origin.length()-1){
                    al.add(storeOthers);
                }
                else if(!(origin.charAt(i+1) >= 'a' && origin.charAt(i+1) <= 'z') && !(origin.charAt(i+1) == '(') && !(origin.charAt(i+1) == '(')){
                    al.add(storeOthers);
                    storeOthers = "";
                }
            }
        }

        if(cntOpen > 0){
            throw new IllegalAccessException("Opening brackes problem");
        }
        else if(cntClose > 0){
            throw new IllegalAccessException("Closing brackes problem");
        }

        return new Result(max, al);
    }
}
