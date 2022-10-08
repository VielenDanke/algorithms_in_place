package leetcode.array.medium.java_solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals_56 {

    private static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(left -> left[0]));
            LinkedList<int[]> list = new LinkedList<>();

            for (int[] interval : intervals) {
                if (list.isEmpty() || list.getLast()[1] < interval[0]) {
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
