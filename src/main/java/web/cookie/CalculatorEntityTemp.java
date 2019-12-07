package web.cookie;

public class CalculatorEntityTemp {
    private final String par1;
    private final String par2;
    private final String op;
    private final String answer;

    public CalculatorEntityTemp(String par1, String par2, String op, String answer) {
        this.par1 = par1;
        this.par2 = par2;
        this.op = op;
        this.answer = answer;
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

    @Override
    public String toString() {
        return " [ " +
                par1 + ", " +
                par2 + ", " +
                op + ", " +
                answer + " ]";
    }
}
