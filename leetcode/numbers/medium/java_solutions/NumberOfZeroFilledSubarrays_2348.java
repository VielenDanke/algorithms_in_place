package leetcode.numbers.medium.java_solutions;

public class NumberOfZeroFilledSubarrays_2348 {

    static class SolutionIndexes {
        public long zeroFilledSubarray(int[] nums) {
            long result = 0;
            int n = nums.length, j = -1;
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    j = i;
                } else {
                    result += i - j;
                }
            }
            return result;
        }
    }

    static class Solution {
        public long zeroFilledSubarray(int[] nums) {
            int currentZeroes = 0;
            long result = 0;
            for (int num : nums) {
                if (num == 0) {
                    currentZeroes++;
                } else {
                    result += sum(currentZeroes);
                    currentZeroes = 0;
                }
            }
            result += sum(currentZeroes);
            return result;
        }

        private long sum(int currentZeroes) {
            long sum = 0;
            while (currentZeroes > 0) {
                sum += currentZeroes--;
            }
            return sum;
        }
    }

    static class SolutionBruteForce {
        public long zeroFilledSubarray(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];

            for (int i = 0; i < n; i++) {
                int counter = 0;
                int j = i;
                while (j >= 0 && nums[j] == 0) {
                    j--;
                    counter++;
                }
                dp[i] = counter;
            }
            long sum = 0;
            for (int num : dp) sum += num;
            return sum;
        }
    }
}
