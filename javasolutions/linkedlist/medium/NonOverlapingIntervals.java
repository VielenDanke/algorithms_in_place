package javasolutions.linkedlist.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class NonOverlapingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(f -> f[1]));

        LinkedList<int[]> list = new LinkedList<>();

        for (int[] interval : intervals) {
            if (list.isEmpty() || list.getLast()[1] <= interval[0]) {
                list.add(interval);
            }
        }
        return intervals.length - list.size();
    }

    public static void main(String[] args) {
        System.out.println(NonOverlapingIntervals.eraseOverlapIntervals(new int[][]{{1,100}, {11,22}, {1,11}, {2,12}}));
    }
}
