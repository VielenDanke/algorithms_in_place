package leetcode.array.medium.java_solutions;

public class MaximalNetworkRank_1615 {

    static class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            int[] roadsToCity = new int[100 + 1];

            boolean[][] roadExists = new boolean[n][n];

            for (int[] cities : roads) {
                roadsToCity[cities[0]]++;
                roadsToCity[cities[1]]++;
                roadExists[cities[0]][cities[1]] = true;
                roadExists[cities[1]][cities[0]] = true;
            }
            int max = 0;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int rank = roadsToCity[i] + roadsToCity[j];
                    if (roadExists[i][j]) {
                        rank--;
                    }
                    max = Math.max(max, rank);
                }
            }
            return max;
        }
    }
}
