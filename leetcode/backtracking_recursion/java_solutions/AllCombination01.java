package leetcode.backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class AllCombination01 {

    public List<List<Integer>> allCombination(int n) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), n);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int n) {
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i <= 1; i++) {
            temp.add(i);
            backtrack(result, temp, n);
            temp.remove(temp.size() - 1);
        }
    }
}
