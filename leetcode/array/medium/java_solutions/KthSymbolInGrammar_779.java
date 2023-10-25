package leetcode.array.medium.java_solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KthSymbolInGrammar_779 {

    static class Solution {
        public int kthGrammar(int n, int k) {
            if (n == 1) {
                return 0;
            }
            int parent = kthGrammar(n - 1, (k + 1) / 2);
            if (k % 2 == 0) {
                return parent == 1 ? 0 : 1;
            }
            return parent;
        }
    }

    static class SolutionQueue {
        public int kthGrammar(int n, int k) {
            if (n == 1) {
                return 0;
            }
            Queue<Integer> currentRow = new LinkedList<>();
            currentRow.offer(0);
            currentRow.offer(1);

            if (n == 2) {
                if (k != 1) {
                    currentRow.poll();
                }
                return currentRow.poll();
            }
            for (int i = 2; i < n; i++) {
                int p = currentRow.size();
                for (int j = 0; j < p && !currentRow.isEmpty(); j++) {
                    Integer num = currentRow.poll();
                    if (num == 0) {
                        currentRow.offer(0);
                        currentRow.offer(1);
                    } else {
                        currentRow.offer(1);
                        currentRow.offer(0);
                    }
                }
            }
            for (int i = 0; i < k - 1; i++) {
                currentRow.poll();
            }
            return currentRow.isEmpty() ? -1 : currentRow.poll();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SolutionQueue().kthGrammar(30, 434991989));
    }

    static class SolutionBruteForce {
        public int kthGrammar(int n, int k) {
            // 1..n indexec row

            List<List<Integer>> l = new ArrayList<>();

            l.add(List.of(0));
            l.add(List.of(0, 1));

            if (n == 1 || n == 2) {
                return l.get(n - 1).get(k - 1);
            }
            for (int i = 2; i < n; i++) {
                List<Integer> prevRow = l.get(i - 1);
                List<Integer> newRow = new ArrayList<>();
                for (int num : prevRow) {
                    if (num == 0) {
                        newRow.add(0);
                        newRow.add(1);
                    } else {
                        newRow.add(1);
                        newRow.add(0);
                    }
                }
                l.add(newRow);
            }
            return l.get(n - 1).get(k - 1);
        }
    }
}
