package month;

public class Month {
    public int run(int month) {
        if(month / 2 == 1 && month % 2 == 0)
            return 28;
        return (30 + month % 2) + (1 - 2 * (month % 2)) * (month / 8);
    }
}
