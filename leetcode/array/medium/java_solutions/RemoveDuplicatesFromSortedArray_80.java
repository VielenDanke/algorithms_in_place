package leetcode.array.medium.java_solutions;

public class RemoveDuplicatesFromSortedArray_80 {

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;

            for (int num : nums) {
                if (i <= 1 || num > nums[i - 2]) {
                    nums[i++] = num;
                }
            }
            return i;
        }
    }
}
