package warmUp._191026;

import java.util.*;

import warmUp._191022.*;

public class CharacterPositions {
    public Map<Character, List<Integer>> process(String origin_) {
        String origin = origin_.toLowerCase();
        // unique
        Set<Character> unique = new HashSet<Character>();
        for (int index = 0; index < origin.length(); index++) {
            char c = origin.charAt(index);
            unique.add(c);
        }
        // map initialization with <char, empty list>
        Map<Character, List<Integer>> positions = new HashMap<>();
        for (Character c : unique) {
            positions.put(c, new ArrayList<>());
        }

        for (int index = 0; index < origin.length(); index++) {
            char c = origin.charAt(index);
            positions.get(c).add(index + 1);
        }
        return positions;
    }

    public String process2(String origin, Map<Character, List<Integer>> result) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < origin.length(); i++) {
            set.add(origin.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Character c : set) {
            sb.append(c + "=" + result.get(c).size() + result.get(c) + ", ");
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        // 1. data obtaining
        RandomStringGenerate l4t1 = new RandomStringGenerate();
        String origin = l4t1.generateRandomString(80);
        origin = origin.toLowerCase();
        // 2. data process
        CharacterPositions app = new CharacterPositions();
        Map<Character, List<Integer>> result = app.process(origin);
        // 3. output the result
        System.out.println(origin);
        System.out.println(result);
        System.out.println(app.process2(origin, result));
    }
}
