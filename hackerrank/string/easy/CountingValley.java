package hackerrank.string.easy;

public class CountingValley {

    static class Solution {

        public static int countingValleys(int steps, String path) {
            /*
            sea level - 0
            consecutive steps below sea level - valley
            */
            int currentLevel = 0, stepsCounter = 0, valley = 0;

            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == 'D') {
                    currentLevel--;
                } else {
                    currentLevel++;
                }
                if (currentLevel < 0) {
                    stepsCounter++;
                } else {
                    if (stepsCounter > 0) {
                        valley++;
                    }
                    stepsCounter = 0;
                }
            }
            if (stepsCounter > 0) {
                valley++;
            }
            return valley;
        }
    }
}
