package warmUp._191022;

public class RandomStringProcess {
    public void process(String s) {
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                if (s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U' || s.charAt(i) == 'Y') {
                    temp += s.charAt(i);
                }
            }
        }
        System.out.println(temp);


        temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                if (s.charAt(i) != 'A' && s.charAt(i) != 'E' && s.charAt(i) != 'I' && s.charAt(i) != 'O' && s.charAt(i) != 'U' && s.charAt(i) != 'Y') {
                    temp += s.charAt(i);
                }
            }
        }
        System.out.println(temp);


        temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'y') {
                    temp += s.charAt(i);
                }
            }
        }
        System.out.println(temp);


        temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                if (s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u' && s.charAt(i) != 'y') {
                    temp += s.charAt(i);
                }
            }
        }
        System.out.println(temp);
    }
}

