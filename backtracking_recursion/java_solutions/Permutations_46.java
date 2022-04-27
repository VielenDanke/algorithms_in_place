package backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, nums, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int left) {
        if (left == nums.length) {
            result.add(IntStream.of(nums).boxed().toList());
            return;
        }
        for (int i = left; i < nums.length; i++) {
            swap(i, left, nums);
            backtrack(result, nums, left + 1);
            swap(i, left, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
