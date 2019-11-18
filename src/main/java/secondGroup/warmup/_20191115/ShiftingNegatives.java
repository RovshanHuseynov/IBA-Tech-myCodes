package secondGroup.warmup._20191115;

import java.util.Random;

public class ShiftingNegatives {
    int [] a;

    public void shift(){
        int f = 0;
        int tempFirst = 0, temp = 0;
        int indFirst = 0;
        for(int i=0; i<a.length; i++){
            if(f == 0 && a[i] < 0){
                f = 1;
                tempFirst = a[i];
                indFirst = i;
            }
            else if(f == 1 && a[i] < 0){
                temp = a[i];
                a[i] = tempFirst;
                f = 2;
            }
            else if(a[i] < 0){
                a[i] = temp;
                temp = a[i];
            }
        }

        a[indFirst] = tempFirst;
    }

    public void print(int len){
        int [] a = new int[len];
        Random random = new Random();
        for(int i=0; i<a.length; i++){
            a[i] = random.nextInt(21) - 10;
            System.out.print(a[i] + " ");
        }
        System.out.println();

        int f = 0;
        int tempFirst = 0, lastNeg = 0;
        int indFirst = 0;
        for(int i=0; i<a.length; i++){
            if(f == 0 && a[i] < 0){
                f = 1;
                tempFirst = a[i];
                indFirst = i;
            }
            else if(f == 1 && a[i] < 0){
                lastNeg = a[i];
                a[i] = tempFirst;
                f = 2;
            }
            else if(a[i] < 0){
                int z = a[i];
                a[i] = lastNeg;
                lastNeg = z;
            }
        }

        a[indFirst] = lastNeg;

        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
