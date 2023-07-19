package leetcode.array.medium.java_solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class NonOverlapingIntervals_435 {

    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(left -> left[1]));

            LinkedList<int[]> list = new LinkedList<>();

            for (int[] interval : intervals) {
                if (list.isEmpty() || interval[0] >= list.getLast()[1]) {
                    list.add(interval);
                }
            }
            return intervals.length - list.size();
        }
    }
}
