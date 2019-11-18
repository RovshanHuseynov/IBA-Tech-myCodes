package warmUp._191118;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private List<String> subject;
    private List<String> verbs;
    private List<String> objects;

    public Combinations(List<String> subject, List<String> verbs, List<String> objects) {
        this.subject = subject;
        this.verbs = verbs;
        this.objects = objects;
    }

    public List<String> method_for() {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < subject.size(); i++) {
            for (int j = 0; j < verbs.size(); j++) {
                for (int k = 0; k < objects.size(); k++) {
                    result.add(subject.get(i) + " " + verbs.get(j) + " " + objects.get(k));
                }
            }
        }
        return result;
    }

    public List<String> method_recursion() {
        List<String> result = new ArrayList<>();
        rec(0, 0, 0, result);
        return result;
    }

    public void rec(int i, int j, int k, List<String> result) {
        result.add(subject.get(i) + " " + verbs.get(j) + " " + objects.get(k));

        if (i == subject.size() - 1 && j == verbs.size() - 1 && k == objects.size() - 1) {
            return;
        }

        if (k < objects.size() - 1) {
            rec(i, j, k + 1, result);
        } else if (j < objects.size() - 1) {
            rec(i, j + 1, 0, result);
        } else if (i < objects.size() - 1) {
            rec(i + 1, 0, 0, result);
        }
    }

    public void print(List<String> result) {
        int cnt = 0;
        for (String item : result) {
            System.out.println(item + " ");
            cnt++;
        }
        System.out.println(cnt);
    }
}
