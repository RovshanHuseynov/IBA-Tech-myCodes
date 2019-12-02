package web.cookie;

public class CalculatorEntity {
    private final int id;
    private final String par1;
    private final String par2;
    private final String op;
    private final String answer;
    private final int userID;

    public CalculatorEntity(int id, String par1, String par2, String op, String answer, int userID) {
        this.id = id;
        this.par1 = par1;
        this.par2 = par2;
        this.op = op;
        this.answer = answer;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public String getPar1() {
        return par1;
    }

    public String getPar2() {
        return par2;
    }

    public String getOp() {
        return op;
    }

    public String getAnswer() {
        return answer;
    }

    public int getUserID() {
        return userID;
    }
}
