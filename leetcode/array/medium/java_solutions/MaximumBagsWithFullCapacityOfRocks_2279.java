package leetcode.array.medium.java_solutions;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumBagsWithFullCapacityOfRocks_2279 {

    static class SolutionNoSpace {
        public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
            int n = capacity.length, result = 0;

            for (int i = 0; i < n; i++) {
                rocks[i] = capacity[i] - rocks[i];
            }
            Arrays.sort(rocks);

            for (int i = 0; i < n && (rocks[i] - additionalRocks) <= 0; i++) {
                result++;
                additionalRocks -= rocks[i];
            }
            return result;
        }
    }

    static class Solution {
        public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
            int n = capacity.length;

            int[][] pairs = new int[n][2];

            for (int i = 0; i < n; i++) {
                pairs[i] = new int[]{capacity[i], rocks[i]};
            }
            Arrays.sort(pairs, Comparator.comparingInt(o -> (o[0] - o[1])));

            int result = 0;

            for (int i = 0; i < n && additionalRocks > 0; i++) {
                int[] currentPair = pairs[i];

                if (currentPair[0] != currentPair[1]) {
                    int diff = Math.min(additionalRocks, currentPair[0] - currentPair[1]);
                    additionalRocks -= diff;
                    currentPair[1] += diff;

                    if (currentPair[0] == currentPair[1]) {
                        result++;
                    }
                } else {
                    result++;
                }
            }
            return result;
        }
    }
}
