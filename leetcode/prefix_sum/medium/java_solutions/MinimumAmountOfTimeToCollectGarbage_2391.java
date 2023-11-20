package leetcode.prefix_sum.medium.java_solutions;

public class MinimumAmountOfTimeToCollectGarbage_2391 {

    static class Solution {

        public int garbageCollection(String[] garbage, int[] travel) {
            // 3 garbage trucks, 1 for M, 1 for P and 1 for G
            // 1 pick = 1 minute
            // travel i -> i + 1 time
            int theMostRightLetterPosition = 16; // 'P' - 'A' = 80 - 65

            char[] trucks = new char[]{'M', 'P', 'G'};

            int n = garbage.length;

            int[] travelTime = new int[n];

            for (int i = 1; i < n; i++) {
                travelTime[i] += travel[i - 1] + travelTime[i - 1];
            }
            int[][] trashTracker = new int[n][theMostRightLetterPosition];

            for (int i = 0; i < garbage.length; i++) {
                trashTracker[i] = new int[theMostRightLetterPosition];
                for (char c : garbage[i].toCharArray()) {
                    trashTracker[i][c - 'A']++;
                }
            }
            int minutes = 0;

            for (char truck : trucks) {
                int lastIdx = 0;
                for (int i = 0; i < garbage.length; i++) {
                    minutes += trashTracker[i][truck - 'A'];
                    if (trashTracker[i][truck - 'A'] > 0) {
                        lastIdx = i;
                    }
                }
                minutes += travelTime[lastIdx];
            }
            return minutes;
        }
    }
}
