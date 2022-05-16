package backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(result, new ArrayList<>(), candidates, target, 0);

        return new ArrayList<>(result);
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int currentNum = candidates[i];
            if (i > start && currentNum == candidates[i - 1]) {
                continue;
            }
            if (target - currentNum < 0) {
                break;
            }
            temp.add(currentNum);
            backtrack(result, temp, candidates, target - currentNum, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
