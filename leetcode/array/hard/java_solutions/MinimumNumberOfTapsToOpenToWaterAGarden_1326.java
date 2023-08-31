package leetcode.array.hard.java_solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MinimumNumberOfTapsToOpenToWaterAGarden_1326 {

    static class Solution {

        private int minCounter = Integer.MAX_VALUE;

        public int minTaps(int n, int[] ranges) {
            int[][] rangesExpanded = new int[n + 1][2];

            for (int i = 0; i < n + 1; i++) {
                rangesExpanded[i] = new int[]{i - ranges[i], i + ranges[i]};
            }
            Arrays.sort(rangesExpanded, Comparator.comparingInt(left -> left[0]));

            System.out.println(Arrays.deepToString(rangesExpanded));

            for (int i = 0; i <= n; i++) {
                LinkedList<int[]> l = new LinkedList<>();
                l.add(rangesExpanded[i]);
                backtrack(l, rangesExpanded, n, i + 1, 1);
            }
            return minCounter == Integer.MAX_VALUE ? -1 : minCounter;
        }

        private void backtrack(LinkedList<int[]> l, int[][] ranges, int n, int j, int counter) {
            if (isCovered(n, l.getLast())) {
                minCounter = Math.min(minCounter, counter);
            }
            for (int i = j; i <= n; i++) {
                if (l.getLast()[1] < ranges[i][0]) {
                    break;
                }
                int last = l.getLast()[1];
                l.getLast()[1] = Math.max(last, ranges[i][1]);
                backtrack(l, ranges, n, i + 1, counter + 1);
                l.getLast()[1] = last;
            }
        }

        private boolean isCovered(int n, int[] interval) {
            return interval[0] <= 0 && interval[1] >= n;
        }
    }
}
