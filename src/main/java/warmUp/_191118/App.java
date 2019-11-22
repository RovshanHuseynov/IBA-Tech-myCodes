package warmUp._191118;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> result;
        Combinations c = new Combinations(Arrays.asList("Noel", "The cat", "The dog"),
                Arrays.asList("slept on", "chased", "wrote"),
                Arrays.asList("slept on", "chased", "wrote"));

        //result = c.method_for();
        //c.print(result);
        result = c.method_recursion();
        c.print(result);
    }
}