package leetcode.array.medium.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections_986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0)
            return new int[][]{};
        int left = 0, right = 0;
        List<int[]> l = new ArrayList<>();
        while (left < firstList.length && right < secondList.length) {
            int[] leftArr = firstList[left];
            int[] rightArr = secondList[right];

            int max = Math.max(leftArr[0], rightArr[0]);
            if (leftArr[1] < rightArr[1]) {
                left++;
                if (max <= leftArr[1]) {
                    l.add(new int[]{max, leftArr[1]});
                }
            } else {
                right++;
                if (max <= rightArr[1]) {
                    l.add(new int[]{max, rightArr[1]});
                }
            }
        }
        return l.toArray(int[][]::new);
    }
}
