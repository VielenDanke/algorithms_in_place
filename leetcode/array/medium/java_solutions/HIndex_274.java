package leetcode.array.medium.java_solutions;

import java.util.Arrays;

public class HIndex_274 {

    static class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] buckets = new int[n + 1];
            for (int citation : citations) {
                buckets[Math.min(citation, n)]++;
            }
            int count = 0;
            for (int i = n; i >= 0; i--) {
                count += buckets[i];
                if (count >= i) return i;
            }
            return 0;
        }
    }

    static class SolutionSort {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int n = citations.length;
            for (int citation : citations) {
                if (citation >= n) {
                    return n;
                }
                n--;
            }
            return n;
        }
    }

    static class SolutionBruteForce {
        public int hIndex(int[] citations) {
            int h = citations.length;

            while (true) {
                int ch = 0;
                for (int citation : citations) {
                    if (citation >= h) {
                        ch++;
                    }
                }
                if (ch >= h) {
                    return h;
                }
                h--;
            }
        }
    }
}
