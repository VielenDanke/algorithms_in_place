package array.easy.java_solutions;

import java.util.Arrays;

public class PivotIndex_724 {

    private static class SolutionBruteForce {

        public int pivotIndex(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (calculateSum(nums, i)) return i;
            }
            return -1;
        }

        private boolean calculateSum(int[] nums, int idx) {
            int leftSum = 0, rightSum = 0;
            for (int i = 0; i < idx; i++) {
                leftSum += nums[i];
            }
            for (int i = idx + 1; i < nums.length; i++) {
                rightSum += nums[i];
            }
            return leftSum == rightSum;
        }
    }

    private static class SolutionOptimized {

        public int pivotIndex(int[] nums) {
            if (nums.length == 0) return -1;
            int N = nums.length;
            int[] prefixSum = new int[N];
            int[] suffixSum = new int[N];

            prefixSum[0] = nums[0];
            suffixSum[N - 1] = nums[N - 1];

            for (int i = 1; i < N; i++) {
                prefixSum[i] = nums[i] + prefixSum[i - 1];
                suffixSum[N - 1 - i] = nums[N - 1 - i] + suffixSum[N - i];
            }
            for (int i = 0; i < N; i++) {
                if (prefixSum[i] == suffixSum[i]) return i;
            }
            return -1;
        }
    }
}
