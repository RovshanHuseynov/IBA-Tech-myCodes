package warmUp._191204;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RemoveDublicate {
    public String remove(String origin) {
        StringBuilder sb = new StringBuilder();
        IntStream step1 = origin.chars();
        Stream<Character> step2 = step1.mapToObj(c -> (char) c);
        Stream<Character> step3 = step2.distinct();
        step3.forEach(c -> sb.append(c));
        return sb.toString();
    }
}
