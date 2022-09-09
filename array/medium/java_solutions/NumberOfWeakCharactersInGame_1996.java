package array.medium.java_solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfWeakCharactersInGame_1996 {

    static class SolutionSort {
        public int numberOfWeakCharacters(int[][] properties) {
            Arrays.sort(properties, (left, right) -> left[0] == right[0] ? (left[1] - right[1]) : right[0] - left[0]);

            int weak = 0, max = 0;

            for (int[] ch : properties) {
                if (ch[1] < max) {
                    weak++;
                }
                max = Math.max(max, ch[1]);
            }
            return weak;
        }
    }

    static class SolutionQueue {
        public int numberOfWeakCharacters(int[][] properties) {
            Queue<int[]> queue = new PriorityQueue<>((left, right) -> (left[0] == right[0]) ? (left[1] - right[1]) : right[0] - left[0]);
            queue.addAll(Arrays.asList(properties));
            int weak = 0;
            int max = 0;
            while (!queue.isEmpty()) {
                int[] first = queue.poll();
                if (first[1] < max) {
                    weak++;
                }
                max = Math.max(max, first[1]);
            }
            return weak;
        }
    }

    static class SolutionBruteForce {
        public int numberOfWeakCharacters(int[][] properties) {
            int weak = 0;
            int n = properties.length;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int[] left = properties[i];
                    int[] right = properties[j];

                    if (left[0] < right[0] && left[1] < right[1] && !visited[i]) {
                        weak++;
                        visited[i] = true;
                    }
                }
            }
            return weak;
        }
    }
}
