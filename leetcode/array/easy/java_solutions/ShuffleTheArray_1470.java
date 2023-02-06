package leetcode.array.easy.java_solutions;

public class ShuffleTheArray_1470 {

    static class Solution {
        public int[] shuffle(int[] nums, int n) {
            int startX = 0;
            int startY = n;

            int[] shuffleNums = new int[2 * n];

            int idx = 0;

            while (idx < 2 * n) {
                shuffleNums[idx++] = nums[startX++];
                shuffleNums[idx++] = nums[startY++];
            }
            return shuffleNums;
        }
    }
}
