package leetcode.dynamic_programming.java_solutions;

public class WaterArea_Algo {

    public static int waterArea(int[] heights) {
        // Write your code here.
        int leftMax = 0, rightMax = 0, total = 0, N = heights.length;
        int[] maxes = new int[N];
        for (int i = 0; i < N; i++) {
            int current = heights[i];
            maxes[i] = leftMax;
            leftMax = Math.max(leftMax, current);
        }
        for (int i = N - 1; i >= 0; i--) {
            int current = heights[i];
            int minHeight = Math.min(rightMax, maxes[i]);
            if (current < minHeight) {
                maxes[i] = minHeight - current;
            } else {
                maxes[i] = 0;
            }
            rightMax = Math.max(rightMax, current);
        }
        for (int i = 0; i < N; i++) total += maxes[i];
        return total;
    }
}
