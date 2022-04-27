package backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), n, k, 1);

        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int n, int k, int start) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(result, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
