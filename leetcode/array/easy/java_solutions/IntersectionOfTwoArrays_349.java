package leetcode.array.easy.java_solutions;

import java.util.*;

public class IntersectionOfTwoArrays_349 {

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> seen = new HashSet<>();

            for (Integer n : nums1) {
                seen.add(n);
            }
            List<Integer> temp = new ArrayList<>();
            for (Integer n : nums2) {
                if (seen.contains(n)) {
                    temp.add(n);
                    seen.remove(n);
                }
            }
            int n = temp.size();
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = temp.get(i);
            }
            return result;
        }
    }
}
