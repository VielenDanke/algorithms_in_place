package leetcode.dynamic_programming.java_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset_368 {

    /*
    class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        nums.sort()
        n = len(nums)
        result = [[num] for num in nums]
        for i in range(n):
            for j in range(i):
                if nums[i] % nums[j] == 0 and len(result[i]) < len(result[j]) + 1:
                    result[i] = result[j] + [nums[i]]
        return max(result, key=lambda x:len(x))

    class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        n = len(nums)
        nums.sort()
        dp = [1] * n
        max_size, max_index = 1, 0

        for i in range(n):
            for j in range(i):
                if nums[i] % nums[j] == 0:
                    dp[i] = max(dp[i], dp[j] + 1)
                    if dp[i] > max_size:
                        max_size = dp[i]
                        max_index = i
        result = []
        num = nums[max_index]
        for i in range(max_index, -1, -1):
            if num % nums[i] == 0 and dp[i] == max_size:
                result.append(nums[i])
                num = nums[i]
                max_size -= 1
        return result
     */

    static class Solution {

        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);

            int n = nums.length;

            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                result.add(new ArrayList<>());
                result.get(i).add(nums[i]);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0 && result.get(i).size() < result.get(j).size() + 1) {
                        ArrayList<Integer> temp = new ArrayList<>(result.get(j));
                        temp.add(nums[i]);
                        result.set(i, temp);
                    }
                }
            }
            return result
                .stream()
                .reduce((integers, integers2) -> {
                    if (integers.size() > integers2.size()) {
                        return integers;
                    }
                    return integers2;
                })
                .orElse(Collections.emptyList());
        }
    }

    static class SolutionBruteForce {
        private List<Integer> answer;

        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            this.answer = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                backtrack(new ArrayList<>(), nums, i);
            }
            return this.answer;
        }

        private void backtrack(List<Integer> temp, int[] nums, int idx) {
            if (idx == nums.length) {
                if (temp.size() > answer.size()) {
                    answer = new ArrayList<>(temp);
                }
                return;
            }
            for (int i = idx; i < nums.length; i++) {
                if (temp.isEmpty() || nums[idx] % temp.get(temp.size() - 1) == 0) {
                    temp.add(nums[idx]);
                    backtrack(temp, nums, i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
