package backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Permutations_46 {

    private static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            backtrack(result, nums, 0);
            return result;
        }

        private void backtrack(List<List<Integer>> result, int[] nums, int start) {
            if (start >= nums.length) {
                result.add(transformToList(nums));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                swap(nums, i, start);
                backtrack(result, nums, start + 1);
                swap(nums, i, start);
            }
        }

        private void swap(int[] nums, int left, int right) {
            int num = nums[left];
            nums[left] = nums[right];
            nums[right] = num;
        }

        private List<Integer> transformToList(int[] nums) {
            List<Integer> list = new LinkedList<>();
            for (int num : nums) list.add(num);
            return list;
        }
    }
}
