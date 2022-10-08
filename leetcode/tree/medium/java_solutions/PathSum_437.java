package leetcode.tree.medium.java_solutions;

import java.util.HashMap;
import java.util.Map;

import static leetcode.tree.Helper.TreeNode;

public class PathSum_437 {

    private static class Solution {

        public int pathSum(TreeNode root, int sum) {
            if (root == null) return 0;
            return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        public int findPath(TreeNode root, long sum) {
            int res = 0;
            if (root == null) {
                return res;
            }
            if (sum == root.val) {
                res++;
            }
            return res + findPath(root.left, sum - root.val) + findPath(root.right, sum - root.val);
        }
    }

    private static class SolutionBetter {

        public int pathSum(TreeNode root, int sum) {
            Map<Long, Integer> map = new HashMap<>();
            map.put(0L, 1);
            return backtrack(root, 0, sum, map);
        }

        public int backtrack(TreeNode root, long sum, int target, Map<Long, Integer> map) {
            if (root == null)
                return 0;
            sum += root.val;

            int res = map.getOrDefault(sum - target, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);

            res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);

            map.put(sum, map.get(sum) - 1);

            return res;
        }
    }
}
