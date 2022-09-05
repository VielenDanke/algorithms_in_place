package unionfind.medium.java_solutions;

public class MostStonesRemovedWithSameRowOrColumn_947 {

    private static class Solution {
        private int[] id;
        private int numOfComponents;

        public int removeStones(int[][] stones) {
            int length = stones.length;
            id = new int[length];
            numOfComponents = length;

            for (int i = 0; i < length; i++) {
                id[i] = i;
            }

            for (int i = 0; i < length; i++) {
                int[] iStone = stones[i];
                for (int j = 0; j < length; j++) {
                    int[] jStone = stones[j];
                    if ((iStone[0] == jStone[0] || iStone[1] == jStone[1]) && !isConnected(i, j)) {
                        union(i, j);
                    }
                }
            }
            return length - numOfComponents;
        }

        private boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }

        private int find(int i) {
            while (i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        private void union(int i, int j) {
            id[find(i)] = find(j);
            numOfComponents--;
        }
    }
}
