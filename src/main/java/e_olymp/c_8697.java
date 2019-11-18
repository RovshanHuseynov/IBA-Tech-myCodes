package e_olymp;

import java.util.Scanner;

public class c_8697 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(s.length() == 1){
            System.out.println("no");
        }

        for(int i=0; i<s.length()-1; i++){
            if(s.substring(0,i+1).equals(s.substring(i+1,s.length()))){
                System.out.println("yes");
                break;
            }

            if(i == s.length()-2){
                System.out.println("no");
            }
        }
    }
}
