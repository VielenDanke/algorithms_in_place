package dynamic_programming.java_solutions;

public class MinimumTimeToMakeRopeColorful_1578 {

    static class Solution {
        public int minCost(String colors, int[] time) {
            int n = colors.length(), result = 0;

            for (int i = 1; i < n; i++) {
                if (colors.charAt(i) == colors.charAt(i - 1)) {
                    result += Math.min(time[i], time[i - 1]);
                    time[i] = Math.max(time[i], time[i - 1]);
                }
            }
            return result;
        }
    }

    static class SolutionRecursive {

        private int n;

        public int minCost(String colors, int[] time) {
            this.n = colors.length();
            return backtrack(colors, time, 0);
        }

        private int backtrack(String colors, int[] time, int start) {
            if (start == n - 1) {
                return 0;
            }
            if (colors.charAt(start) == colors.charAt(start + 1)) {
                if (time[start + 1] < time[start]) {
                    swap(time, start, start + 1);
                }
                return Math.min(time[start], time[start + 1]) + backtrack(colors, time, start + 1);
            } else {
                return backtrack(colors, time, start + 1);
            }
        }

        private void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
    }
}
