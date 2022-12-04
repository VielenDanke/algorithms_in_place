package leetcode.array.medium.java_solutions;

public class MinimumAverageDifference_2256 {

    static class SolutionPrefixSumWithoutArray {

        public int minimumAverageDifference(int[] nums) {
            long min = Long.MAX_VALUE, leftSum = 0, sum = 0;
            int minIdx = 0, n = nums.length;;

            for (int num : nums) {
                sum += num;
            }
            for (int i = 0; i < n; i++) {
                leftSum += nums[i];
                long rightSum = sum - leftSum;
                long diff = Math.abs(leftSum / (i + 1) - (n - i == 1 ? 0 : rightSum / (n - i - 1)));
                if (min > diff) {
                    min = diff;
                    minIdx = i;
                }
            }
            return minIdx;
        }
    }

    static class SolutionPrefixSum {
        public int minimumAverageDifference(int[] nums) {
            int n = nums.length;
            long[] prefixSum = new long[n];
            long[] suffixSum = new long[n];

            prefixSum[0] = nums[0];
            suffixSum[n - 1] = nums[n - 1];

            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
            for (int i = n - 2; i >= 0; i--) {
                suffixSum[i] = suffixSum[i + 1] + nums[i];
            }
            int minIdx = 0;
            long min = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                long leftAverage = prefixSum[i] / (i + 1);
                long rightAverage = n - i == 1 ? 0 : suffixSum[i + 1] / (n - i - 1);
                long diff = Math.abs(leftAverage - rightAverage);
                if (min > diff) {
                    min = diff;
                    minIdx = i;
                }
            }
            return minIdx;
        }
    }

    static class SolutionTimeLimit {
        public int minimumAverageDifference(int[] nums) {
            if (nums.length == 0) return 0;

            int idx = 0, min = 1 << 30, minIdx = 0;

            while (idx < nums.length) {
                int leftAverage = 0;
                int counter = 0;
                for (int i = 0; i <= idx; i++) {
                    leftAverage += nums[i];
                    counter++;
                }
                if (counter > 0) {
                    leftAverage = leftAverage / counter;
                }
                counter = 0;
                int rightAverage = 0;
                for (int i = idx + 1; i < nums.length; i++) {
                    rightAverage += nums[i];
                    counter++;
                }
                if (counter > 0) {
                    rightAverage = rightAverage / counter;
                }
                int diff = Math.abs(leftAverage - rightAverage);
                if (min > diff) {
                    min = diff;
                    minIdx = idx;
                }
                idx++;
            }
            return minIdx;
        }
    }
}
