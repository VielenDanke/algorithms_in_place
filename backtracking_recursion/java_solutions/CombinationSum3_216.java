package backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), k, n, 1, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int n, int start, int sum) {
        if (temp.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtrack(result, temp, k, n, i + 1, sum + i);
            temp.remove(temp.size() - 1);
        }
    }
}
