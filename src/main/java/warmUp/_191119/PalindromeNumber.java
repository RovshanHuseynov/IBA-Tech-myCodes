package warmUp._191119;

public class PalindromeNumber {

    public boolean isPalindrome(int n) {
        String number = Integer.toString(n);
        int len = number.length();
        int mid_i = len%2 == 1 ? len/2 : len/2-1;
        int mid_j = len/2;

        for(int i=0, j=len-1; (i<=mid_i)&&(j>=mid_j); i++, j--){
            if(number.charAt(i) != number.charAt(j)) return false;
        }
        return true;
    }
}