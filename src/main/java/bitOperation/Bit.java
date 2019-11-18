package bitOperation;

public class Bit {
    public static void main(String[] args) {
        /*
        System.out.println(43 & 56);
        System.out.println(43 | 56);
        System.out.println(43 ^ 56);
        System.out.println(~43);
        System.out.println(11>>1);
        System.out.println(11<<1);
         */

        Bit b = new Bit();
        System.out.println(b.call(25));

        System.out.println((25>>0)&1);
        System.out.println((25>>1)&1);
        System.out.println((25>>2)&1);
        System.out.println((25>>3)&1);
        System.out.println((25>>4)&1);
    }

    public String call(int x){
        String s = "";
        while(x > 0){
            s += x%2;
            x = x / 2;
        }

        String s1 = "";
        for(int i=s.length()-1; i>=0; i--){
            s1 += s.charAt(i);
        }
        return s1;
    }
}
