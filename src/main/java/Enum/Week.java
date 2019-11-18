package Enum;

enum Months {
    January,
    February,
    March
}

public class Week {
    static {
        System.out.println("getdik");
    }

    public static void main(String[] args) {
        EnumClass eC = EnumClass.MONDAY;
        System.out.println(eC);

        Months m = Months.January;
        System.out.println(m);
        for (Months item : Months.values()){
            System.out.println(item);
        }
    }
}