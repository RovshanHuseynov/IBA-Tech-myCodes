package warmUp._191031;

public class CalcSum {
    public static void main(String[] args) {
        String origin = "4/9+5/7";
        CalcSum cs = new CalcSum();
        System.out.println(cs.splitPlus(origin));
    }

    public String splitPlus(String origin){
        String [] s1 = origin.split("\\+");
        Kesr ans = new Kesr();
        ans = splitDivide(s1[0]);

        for(int i=1; i<s1.length; i++){
            Kesr k = new Kesr();
            k = splitDivide(s1[i]);
            if(ans.getMexrec() == k.getMexrec()){
                ans.setSuret(ans.getSuret() + k.getSuret());
            }
            else {
                ans.setSuret(ans.getSuret()*k.getMexrec() + k.getSuret()*ans.getMexrec());
                ans.setMexrec(ans.getMexrec() * k.getMexrec());
            }
        }

        if(ans.getMexrec() == 1){
            return ans.getSuret() + "";
        }
        else {
            return ans.getSuret() + "/" + ans.getMexrec();
        }
    }

    public Kesr splitDivide(String origin) {
        Kesr k = new Kesr();

        String [] s2 = origin.split("/");
        if(s2.length == 2){
            k.setSuret(Integer.parseInt(s2[0]));
            k.setMexrec(Integer.parseInt(s2[1]));
            return k;
        }
        else{
            k.setSuret(Integer.parseInt(s2[0]));
            k.setMexrec(1);
            return k;
        }
    }
}
