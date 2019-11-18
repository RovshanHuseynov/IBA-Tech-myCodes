package warmUp._191105;

public class maainnn {
    public static void main(String[] args) throws IllegalAccessException {
        ParenthesesLevel aa = new ParenthesesLevel();
        Result r = aa.calc(".(aaaa)(bb.bbb)");
        System.out.println(r.getParenthesesLevel());
        for(String item : r.getAl()){
            System.out.print(item + " ");
        }
    }
}
