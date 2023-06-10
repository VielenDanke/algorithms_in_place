package leetcode.strings.easy.java_solution;

public class FindTheShortestDistanceBetweenXandY_TestTask {

    static class Solution {

        // "OOOOXOOYOXO" test input
        // String can contain only X, Y, O
        public int findShortestDistanceBetweenXAndY(String str) {
            if (str == null) return 0;

            Integer lastSeenX = null;
            Integer lastSeenY = null;

            int minDistance = Integer.MAX_VALUE;

            for (int i = 0; i < str.length(); i++) {
                char current = str.charAt(i);

                if (current == 'X') {
                    if (lastSeenY != null) {
                        minDistance = Math.min(minDistance, i - lastSeenY);
                    }
                    lastSeenX = i;
                } else if (current == 'Y') {
                    if (lastSeenX != null) {
                        minDistance = Math.min(minDistance, i - lastSeenX);
                    }
                    lastSeenY = i;
                }
            }
            if (lastSeenY == null || lastSeenX == null) {
                return 0;
            }
            return minDistance;
        }
    }
}
