package warmUp._191105;

import java.util.ArrayList;

public class Result {
    private int ParenthesesLevel;
    private ArrayList<String> al;

    public Result(int parenthesesLevel, ArrayList<String> al) {
        ParenthesesLevel = parenthesesLevel;
        this.al = al;
    }

    public int getParenthesesLevel() {
        return ParenthesesLevel;
    }

    public ArrayList<String> getAl() {
        return al;
    }
}
