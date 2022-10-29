package leetcode.array.hard.java_solutions;

import java.util.*;

public class EarliestPossibleDayOfFullBloom_2136 {

    static class SolutionPair {
        public int earliestFullBloom(int[] plantTime, int[] growTime) {
            int n = plantTime.length;
            Pair[] flowerTime = new Pair[n];
            for (int i = 0; i < n; i++) {
                flowerTime[i] = new Pair(plantTime[i], growTime[i]);
            }
            Arrays.sort(flowerTime, (a, b) -> b.growTime - a.growTime);
            int plantingDays = 0;
            int totalDays = 0;
            for (Pair current : flowerTime) {
                totalDays = Math.max(totalDays, plantingDays + current.plantTime + current.growTime);
                plantingDays += current.plantTime;
            }
            return totalDays;
        }

        static class Pair {
            public int plantTime;
            public int growTime;

            Pair(int plantTime, int growTime) {
                this.plantTime = plantTime;
                this.growTime = growTime;
            }
        }
    }

    static class Solution {

        public int earliestFullBloom(int[] plantTime, int[] growTime) {
            int n = growTime.length;
            Integer[] indices = new Integer[n];
            for (int i = 0; i < n; ++i) {
                indices[i] = i;
            }
            Arrays.sort(indices, Comparator.comparingInt(i -> -growTime[i]));
            int max = 0;
            for (int i = 0, plantSum = 0; i < n; ++i) {
                int idx = indices[i];
                int time = plantSum + plantTime[idx] + growTime[idx];
                max = Math.max(max, time);
                plantSum += plantTime[idx];
            }
            return max;
        }
    }

    static class SolutionBruteForce {
        private int n;

        public int earliestFullBloom(int[] plantTime, int[] growTime) {
            n = plantTime.length;

            return backtrack(plantTime, growTime, new int[n], 0, new boolean[n], 0);
        }

        private int backtrack(int[] plantTime, int[] growTime, int[] finalDay, int work, boolean[] visited, int counter) {
            if (counter == n) {
                int max = 0;
                for (int i = 0; i < n; i++) {
                    max = Math.max(max, Math.max(work, finalDay[i]));
                }
                return max;
            }
            int min = 1 << 30;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    work += plantTime[i];
                    finalDay[i] = work + growTime[i];
                    min = Math.min(min, backtrack(plantTime, growTime, finalDay, work, visited, counter + 1));
                    finalDay[i] = 0;
                    work -= plantTime[i];
                    visited[i] = false;
                }
            }
            return min;
        }
    }
}
