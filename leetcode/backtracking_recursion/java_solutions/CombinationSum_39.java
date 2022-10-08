package leetcode.backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                continue;
            }
            temp.add(candidates[i]);
            backtrack(result, temp, candidates, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
