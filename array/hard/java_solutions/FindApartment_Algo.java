package array.hard.java_solutions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FindApartment_Algo {

    // O(N * M) time | O(N * M) space

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
        int N = blocks.size();
        int M = reqs.length;
        int[][] reqDistances = new int[M][N];
        for (int i = 0; i < M; i++) {
            reqDistances[i] = calculateDistances(blocks, reqs[i]);
        }
        int[] maxDistancesAtBlock = getMaxDistancesAtBlocks(blocks, reqDistances);
        return findMinIdx(maxDistancesAtBlock);
    }

    private static int findMinIdx(int[] distances) {
        int minIdx = 0;
        int minDist = distances[0];
        for (int i = 1; i < distances.length; i++) {
            int current = distances[i];
            if (current < minDist) {
                minDist = current;
                minIdx = i;
            }
        }
        return minIdx;
    }

    private static int[] getMaxDistancesAtBlocks(List<Map<String, Boolean>> blocks, int[][] reqDistances) {
        int N = blocks.size();
        int[] maxDistancesAtBlock = new int[N];
        for (int[] reqDistance : reqDistances) {
            for (int j = 0; j < N; j++) {
                maxDistancesAtBlock[j] = Math.max(maxDistancesAtBlock[j], reqDistance[j]);
            }
        }
        return maxDistancesAtBlock;
    }

    private static int[] calculateDistances(List<Map<String, Boolean>> blocks, String req) {
        int N = blocks.size();
        int[] minDistances = new int[N];
        int closestReqIdx = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (blocks.get(i).get(req)) {
                closestReqIdx = i;
            }
            minDistances[i] = Math.abs(i - closestReqIdx);
        }
        for (int i = N - 1; i >= 0; i--) {
            if (blocks.get(i).get(req)) {
                closestReqIdx = i;
            }
            minDistances[i] = Math.min(minDistances[i], Math.abs(i - closestReqIdx));
        }
        return minDistances;
    }

    // --------------------------------------------------------------------------------------
    // O(N^2 * M) Time | O(N) space | N - number of blocks, M - number of requirements

    public static int apartmentHuntingLessProductive(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
        int N = blocks.size();
        int[] maxDistances = new int[N];
        Arrays.fill(maxDistances, Integer.MIN_VALUE);
        for (int i = 0; i < N; i++) {
            for (String req : reqs) {
                int closestDistance = Integer.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (blocks.get(j).get(req)) {
                        closestDistance = Math.min(closestDistance, Math.abs(i - j));
                    }
                }
                maxDistances[i] = Math.max(maxDistances[i], closestDistance);
            }
        }
        return findMinDistance(maxDistances);
    }

    private static int findMinDistance(int[] distances) {
        int idx = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < distances.length; i++) {
            int currentDistance = distances[i];
            if (currentDistance < minValue) {
                idx = i;
                minValue = currentDistance;
            }
        }
        return idx;
    }
}
