package leetcode.array.hard.java_solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MinimumNumberOfTapsToOpenToWaterAGarden_1326 {

    static class Solution {

        public int minTaps(int n, int[] ranges) {
            int[][] rangesExpanded = new int[n + 1][2];

            for (int i = 0; i < n + 1; i++) {
                rangesExpanded[i] = new int[]{i - ranges[i], i + ranges[i]};
            }
            Arrays.sort(rangesExpanded, Comparator.comparingInt(left -> left[0]));

            System.out.println(Arrays.deepToString(rangesExpanded));

            Integer minCounter = null;

            for (int i = 0; i < n + 1; i++) {
                LinkedList<int[]> l = new LinkedList<>();
                l.add(rangesExpanded[i]);
                Integer counter = backtrack(l, rangesExpanded, n, i + 1);
                if (counter != null) {
                    minCounter = Math.min(counter, minCounter == null ? Integer.MAX_VALUE : minCounter);
                }
            }
            return minCounter == null ? -1 : minCounter;
        }

        private Integer backtrack(LinkedList<int[]> l, int[][] ranges, int n, int j) {
            if (isCovered(n, l.getLast())) {
                return 1;
            }
            Integer min = null;
            for (int i = j; i <= n; i++) {
                if (l.getLast()[1] < ranges[i][0]) {
                    break;
                }
                int last = l.getLast()[1];
                l.getLast()[1] = Math.max(last, ranges[i][1]);
                Integer current = backtrack(l, ranges, n, i + 1);
                l.getLast()[1] = last;
                if (current != null) {
                    min = Math.min(min == null ? Integer.MAX_VALUE : min, current + 1);
                }
            }
            return min;
        }

        private boolean isCovered(int n, int[] interval) {
            return interval[0] <= 0 && interval[1] >= n;
        }
    }
}
