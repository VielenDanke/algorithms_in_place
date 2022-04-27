package backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDuplication_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(result, new LinkedList<>(), nums, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, LinkedList<Integer> temp, int[] nums, int start) {
        result.add(new LinkedList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);
            temp.removeLast();
        }
    }
}
