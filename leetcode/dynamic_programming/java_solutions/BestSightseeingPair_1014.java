package leetcode.dynamic_programming.java_solutions;

public class BestSightseeingPair_1014 {

    static class SolutionBruteForce {
        public int maxScoreSightseeingPair(int[] values) {
            int max = 0, len = values.length;

            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    int tempMax = values[i] + values[j] + j - i;
                    max = Math.max(max, tempMax);
                }
            }
            return max;
        }
    }

    static class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int result = 0, current = 0;
            for (int number : values) {
                result = Math.max(result, current + number);
                current = Math.max(current, number) - 1;
            }
            return result;
        }
    }
}
