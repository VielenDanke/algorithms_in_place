package leetcode.array.easy.java_solutions;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum_2389 {

    static class SolutionBinarySearch {
        public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);

            int n = nums.length, m = queries.length;

            for (int i = 1; i < n; i++) {
                nums[i] += nums[i - 1];
            }
            for (int i = 0; i < m; i++) {
                int j = Arrays.binarySearch(nums, queries[i]);
                queries[i] = Math.abs(j + 1);
            }
            return queries;
        }
    }

    static class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);

            int n = nums.length, m = queries.length;

            for (int i = 0; i < m; i++) {
                int query = queries[i];

                int tempSum = 0;
                int counter = 0;

                for (int j = 0; j < n && tempSum + nums[j] <= query; j++) {
                    tempSum += nums[j];
                    counter++;
                }
                queries[i] = counter;
            }
            return queries;
        }
    }
}
