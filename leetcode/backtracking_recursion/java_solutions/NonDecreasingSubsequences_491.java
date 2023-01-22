package leetcode.backtracking_recursion.java_solutions;

import java.util.*;

public class NonDecreasingSubsequences_491 {

    static class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();

            backtrack(result, new LinkedList<>(), nums, 0);

            return new LinkedList<>(result);
        }

        private void backtrack(List<List<Integer>> result, LinkedList<Integer> temp, int[] nums, int idx) {
            if (temp.size() >= 2) {
                result.add(new LinkedList<>(temp));
            }
            Set<Integer> used = new HashSet<>();
            for (int i = idx; i < nums.length; i++) {
                if (used.contains(nums[i])) continue;
                if (temp.isEmpty() || nums[i] >= temp.peekLast()) {
                    temp.add(nums[i]);
                    used.add(nums[i]);
                    backtrack(result, temp, nums, i + 1);
                    temp.removeLast();
                }
            }
        }
    }

    static class SolutionUsingSetAsResult {
        public List<List<Integer>> findSubsequences(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();

            backtrack(result, new LinkedList<>(), nums, 0);

            return new LinkedList<>(result);
        }

        private void backtrack(Set<List<Integer>> result, LinkedList<Integer> temp, int[] nums, int idx) {
            if (temp.size() >= 2) {
                result.add(new LinkedList<>(temp));
            }
            for (int i = idx; i < nums.length; i++) {
                if (temp.isEmpty() || nums[i] >= temp.peekLast()) {
                    temp.add(nums[i]);
                    backtrack(result, temp, nums, i + 1);
                    temp.removeLast();
                }
            }
        }
    }
}
