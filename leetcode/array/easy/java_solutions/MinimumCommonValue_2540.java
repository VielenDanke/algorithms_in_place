package leetcode.array.easy.java_solutions;

public class MinimumCommonValue_2540 {

    static class Solution {
        public int getCommon(int[] nums1, int[] nums2) {
            int left = 0, right = 0, n1 = nums1.length, n2 = nums2.length;

            while (left < n1 && right < n2) {
                if (nums2[right] < nums1[left]) {
                    right++;
                } else if (nums1[left] < nums2[right]) {
                    left++;
                } else {
                    return nums1[left];
                }
            }
            return -1;
        }
    }
}
