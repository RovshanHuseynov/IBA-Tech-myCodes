public class Task1 {

  public String gen_random(int length) {
    int range = 'Z' - 'A' + 1;
    String outcome = "";
    for (int i = 0; i < length; i++) {
      boolean way = (int)((Math.random()*100))%2==0;
//      char c = (char) (Math.random()*range + (way ? 'A' : 'a'));
      char c = (char) (Math.random()*range + 'A');
      if (way) {
        c = Character.toLowerCase(c);
      }
      outcome = outcome + c;
    }
    return outcome;
  }

  public static void main(String[] args) {
    Task1 t = new Task1();
    String s1 = t.gen_random(10); // nhdfsccrsr
    String s2 = t.gen_random(5); // gsfed

    if (s1.length() == 10) {
      System.out.println("OK");
    } else {
      System.out.println("ERR");
    }

    System.out.println(s1);
    System.out.println(s2);
  }
}
