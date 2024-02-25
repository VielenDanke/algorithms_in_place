package leetcode.graph.hard;

import leetcode.structures.java_solutions.UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreatestCommonDivisorTraversal_2709 {

    static class SolutionUnionFindImproved {

        private static final int LIMIT = 100001;

        public boolean canTraverseAllPairs(int[] nums) {
            int n = nums.length;

            if (n == 0) return true;

            UnionFind unionFind = new UnionFind(LIMIT);

            for (int num : nums) {
                List<Integer> list = getFactors(num);
                for (int val : list) {
                    unionFind.union(val, num);
                }
            }
            int p = unionFind.find(nums[0]);

            for (int num : nums) {
                if (num == 1 && n > 1) {
                    return false;
                }
                if (p != unionFind.find(num)) {
                    return false;
                }
            }
            return true;
        }

        private List<Integer> getFactors(int num) {
            List<Integer> res = new ArrayList<>();

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    res.add(i);
                    res.add(num / i);
                }
            }
            return res;
        }
    }

    static class SolutionUnionFind {
        public boolean canTraverseAllPairs(int[] nums) {
            List<int[]> pairs = new ArrayList<>();

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    pairs.add(new int[]{j, i});
                }
            }
            UnionFind unionFind = new UnionFind(nums.length);

            for (int[] pair : pairs) {
                if (!unionFind.isConnected(pair[0], pair[1]) && findGcd(nums[pair[0]], nums[pair[1]]) > 1) {
                    unionFind.union(pair[0], pair[1]);
                }
            }
            return unionFind.getNumComponents() == 1;
        }
    }

    private static int findGcd(int left, int right) {
        if (right == 0) {
            return left;
        } else {
            return findGcd(right, left % right);
        }
    }
}
