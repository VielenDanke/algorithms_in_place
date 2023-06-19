package leetcode.array.easy.java_solutions;

public class FindTheHighestAltitude_1732 {

    static class Solution {
        public int largestAltitude(int[] gain) {
            int n = gain.length;

            int[] prefixSum = new int[n];

            int maxAltitude = 0;

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    prefixSum[i] = prefixSum[i - 1] + gain[i];
                } else {
                    prefixSum[i] = gain[i];
                }
                maxAltitude = Math.max(maxAltitude, prefixSum[i]);
            }
            return maxAltitude;
        }
    }

    static class SolutionNoArray {
        public int largestAltitude(int[] gain) {
            int maxAttitude = 0, currentSum = 0;

            for (int i = 0; i < gain.length; i++) {
                if (i > 0) {
                    currentSum = currentSum + gain[i];
                } else {
                    currentSum = gain[i];
                }
                maxAttitude = Math.max(maxAttitude, currentSum);
            }
            return maxAttitude;
        }
    }
}
