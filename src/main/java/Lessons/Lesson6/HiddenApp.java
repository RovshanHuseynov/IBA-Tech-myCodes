package Lessons.Lesson6;

import java.util.Iterator;

public class HiddenApp {
  public static void main(String[] args) {
    HiddenData months = new HiddenData();
    /*
    for (String month: months) {
      System.out.printf("** %s **\n", month);
    }
    */

    Iterator<String> it = months.iterator();
    while (it.hasNext()) {
      System.out.printf(">> %s <<\n", it.next());
    }

    //months.forEach(m -> System.out.printf("<< %s >>\n", m));
  }
}
