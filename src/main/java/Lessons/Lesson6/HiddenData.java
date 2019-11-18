package Lessons.Lesson6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class HiddenData implements Iterable<String> {
  private final List<String> months = Arrays.asList(
      "Jan","Feb","Mar","Apr","May");

  @Override
  public Iterator<String> iterator() {
    Iterator<String> iterator = new Iterator<String>() {
      Random random = new Random();
      boolean[] check = new boolean[months.size()];
      int cnt = 0, index;

      @Override
      public boolean hasNext() {
        return cnt < months.size();
      }

      @Override
      public String next() {
        while(true){
          index = random.nextInt(months.size());

          if(cnt<=months.size() && !check[index]){
            check[index] = true;
            cnt ++;
            break;
          }
        }
        return months.get(index);
      }
    };

    return iterator;
  }
}
