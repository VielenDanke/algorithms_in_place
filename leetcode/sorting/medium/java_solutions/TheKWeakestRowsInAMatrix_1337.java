package leetcode.sorting.medium.java_solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class TheKWeakestRowsInAMatrix_1337 {

    static class SolutionBinarySearch {
        public int[] kWeakestRows(int[][] mat, int k) {
            int n = mat.length;
            int[] answer = new int[k];
            int[] soldiers = new int[n];

            for (int i = 0; i < n; i++) {
                int[] people = mat[i];
                soldiers[i] = searchFirstCivilianIndex(people);
            }
            Queue<Integer> queue = formOrderQueue(soldiers, n);
            
            for (int i = 0; i < k && !queue.isEmpty(); i++) {
                answer[i] = queue.poll();
            }
            return answer;
        }

        private int searchFirstCivilianIndex(int[] arr) {
            int left = 0, right = arr.length - 1;

            while (left <= right) {
                int middle = left + (right - left) / 2;

                if (arr[middle] == 1) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            return left;
        }
    }

    static class SolutionQueue {
        public int[] kWeakestRows(int[][] mat, int k) {
            int n = mat.length;
            int[] answer = new int[k];
            int[] soldiers = new int[n];

            for (int i = 0; i < n; i++) {
                int[] people = mat[i];
                soldiers[i] = countSoldiers(people);
            }
            Queue<Integer> queue = formOrderQueue(soldiers, n);

            for (int i = 0; i < k && !queue.isEmpty(); i++) {
                answer[i] = queue.poll();
            }
            return answer;
        }

        private int countSoldiers(int[] people) {
            int counter = 0;
            for (int i = 0; i < people.length && people[i] != 0; i++) {
                counter++;
            }
            return counter;
        }
    }

    private static Queue<Integer> formOrderQueue(int[] soldiers, int n) {
        Queue<Integer> queue = new PriorityQueue<>((left, right) -> {
            if (soldiers[left] == soldiers[right]) {
                return left - right;
            }
            return soldiers[left] - soldiers[right];
        });

        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        return queue;
    }
}
