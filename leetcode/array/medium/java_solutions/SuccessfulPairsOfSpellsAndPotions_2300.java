package leetcode.array.medium.java_solutions;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions_2300 {

    static class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);

            int n = spells.length, m = potions.length;

            for (int i = 0; i < n; i++) {
                spells[i] = m - binarySearch(potions, spells[i], success);
            }
            return spells;
        }

        private int binarySearch(int[] arr, int add, long success) {
            int left = 0, right = arr.length - 1;

            while (left <= right) {
                int middle = left + (right - left) / 2;

                if ((long) arr[middle] * add >= success) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            return left;
        }
    }
}
