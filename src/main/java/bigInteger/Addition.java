package bigInteger;

public class Addition {
    public String add(String s1, String s2) {
        int len_a = s1.length();
        int len_b = s2.length();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        for (int i = len_a - 1; i >= 0; i--) {
            a.append(s1.charAt(i));
        }

        for (int i = len_b - 1; i >= 0; i--) {
            b.append(s2.charAt(i));
        }

        if (len_a > len_b) {
            int dif = len_a - len_b;
            for (int i = 1; i <= dif; i++) {
                b.append('0');
            }
        } else if (len_a < len_b) {
            int dif = len_b - len_a;
            for (int i = 1; i <= dif; i++) {
                a.append('0');
            }
        }

        len_a = a.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int memory = 0;

        while (i < len_a) {
            int temp = (int)(a.charAt(i) - '0') + (int)(b.charAt(i) - '0');
            //System.out.println("temp: " + temp);
            temp += memory;
            //System.out.println("temp: " + temp);
            memory = temp / 10;
            //System.out.println("memory: " + memory);
            temp -= memory * 10;
            //System.out.println("temp: " + temp);
            i++;
            //System.out.println();

            sb.append(temp);
        }
        if(memory != 0){
            sb.append(memory);
        }
        StringBuilder c = new StringBuilder();
        for(int j=sb.length()-1; j>=0; j--){
            c.append(sb.charAt(j));
        }

        return c.toString();
    }
}