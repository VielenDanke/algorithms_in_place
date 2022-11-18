package hackerrank.array.easy.java_solutions;

public class ElectronicShop {

    // https://www.hackerrank.com/challenges/electronics-shop

    static class Solution {
        static int getMoneySpent(int[] keyboards, int[] drives, int b) {
            /*
             * Write your code here.
             */
            int maxDiff = Integer.MAX_VALUE;
            int cost = -1;

            for (int keyboard : keyboards) {
                for (int drive : drives) {
                    int tempSum = keyboard + drive;
                    int diff = Math.abs(b - tempSum);
                    if (diff < maxDiff && tempSum <= b) {
                        maxDiff = diff;
                        cost = tempSum;
                    }
                }
            }
            return cost;
        }
    }

    static class SolutionRecursive {
        private static int maxCost;
        private static int maxDiff;

        static int getMoneySpent(int[] keyboards, int[] drives, int b) {
            /*
             * Write your code here.
             */
            maxCost = Integer.MIN_VALUE;
            maxDiff = Integer.MAX_VALUE;
            backtrack(keyboards, drives, 0, 0, b);
            return maxCost == Integer.MIN_VALUE ? -1 : maxCost;
        }

        private static void backtrack(int[] keyboards, int[] drives, int keyboardsIdx, int drivesIdx, int b) {
            if (keyboardsIdx >= keyboards.length || drivesIdx >= drives.length) return;
            int currentSum = keyboards[keyboardsIdx] + drives[drivesIdx];
            int diff = Math.abs(b - currentSum);
            if (currentSum < b && maxDiff > diff) {
                maxCost = currentSum;
                maxDiff = diff;
            }
            backtrack(keyboards, drives, keyboardsIdx + 1, drivesIdx, b);
            backtrack(keyboards, drives, keyboardsIdx, drivesIdx + 1, b);
        }
    }
}
