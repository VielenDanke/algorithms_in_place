package leetcode.array.easy.java_solutions;

import java.util.*;

public class FindTheDifferenceOfTwoArrays_2215 {

    static class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            Set<Integer> left = new HashSet<>();
            Set<Integer> right = new HashSet<>();

            for (int num : nums1) {
                left.add(num);
            }
            for (int num : nums2) {
                right.add(num);
            }
            List<List<Integer>> result = new ArrayList<>();
            for (int num : nums2) {
                left.remove(num);
            }
            result.add(new ArrayList<>(left));
            for (int num : nums1) {
                right.remove(num);
            }
            result.add(new ArrayList<>(right));
            return result;
        }
    }

    static class SolutionArray {

        private static final int INCREMENTER = 1000;

        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            return Arrays.asList(difference(nums1, nums2), difference(nums2, nums1));
        }

        private List<Integer> difference(int[] first, int[] second) {
            List<Integer> difference = new ArrayList<>();
            boolean[] seen = new boolean[1001 + INCREMENTER];

            for (int i : second) {
                seen[i + INCREMENTER] = true;
            }

            for (int i : first) {
                if (!seen[i + INCREMENTER]) {
                    seen[i + INCREMENTER] = true;
                    difference.add(i);
                }
            }
            return difference;
        }
    }
}
