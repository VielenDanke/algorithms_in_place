package leetcode.backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    // ----------------------------------------------------------------------------------------------

    public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());

        for (int element : nums) {
            int length = subsets.size();
            for (int i = 0; i < length; i++) {
                List<Integer> current = new ArrayList<>(subsets.get(i));
                current.add(element);
                subsets.add(current);
            }
        }
        return subsets;
    }
}
