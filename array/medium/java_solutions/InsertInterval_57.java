package array.medium.java_solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class InsertInterval_57 {

    private static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int[][] mergedInterval = new int[intervals.length + 1][2];
            System.arraycopy(intervals, 0, mergedInterval, 0, intervals.length);
            mergedInterval[intervals.length] = newInterval;

            Arrays.sort(mergedInterval, Comparator.comparingInt(left -> left[0]));

            LinkedList<int[]> list = new LinkedList<>();

            for (int[] interval : mergedInterval) {
                if (list.isEmpty() || interval[0] > list.getLast()[1]) {
                    list.add(interval);
                } else {
                    int[] lastInterval = list.pollLast();
                    lastInterval[1] = Math.max(lastInterval[1], interval[1]);
                    list.add(lastInterval);
                }
            }
            int[][] result = new int[list.size()][2];
            int idx = 0;
            for (int[] interval : list) {
                result[idx++] = interval;
            }
            return result;
        }
    }
}
