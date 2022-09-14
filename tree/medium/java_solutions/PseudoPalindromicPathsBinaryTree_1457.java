package tree.medium.java_solutions;

import java.util.HashSet;
import java.util.Set;

import static tree.Helper.TreeNode;

public class PseudoPalindromicPathsBinaryTree_1457 {

    static class Solution {
        public int pseudoPalindromicPaths(TreeNode root) {
            return canBePalindrome(root, new HashSet<>());
        }

        private int canBePalindrome(TreeNode node, Set<Integer> numbers) {
            if (node == null) return 0;
            if (numbers.contains(node.val)) {
                numbers.remove(node.val);
            } else {
                numbers.add(node.val);
            }
            if (node.left == null && node.right == null) {
                return numbers.size() <= 1 ? 1 : 0;
            }
            int left = canBePalindrome(node.left, new HashSet<>(numbers));
            int right = canBePalindrome(node.right, new HashSet<>(numbers));
            return left + right;
        }
    }

    static class SolutionMap {
        int result = 0;

        public int pseudoPalindromicPaths(TreeNode root) {
            int[] valuesTracker = new int[10];
            dfs(root, valuesTracker);
            return result;
        }

        void dfs(TreeNode root, int[] valuesTracker) {

            if (root == null) {
                return;
            }
            valuesTracker[root.val] = valuesTracker[root.val] + 1;

            if (root.left == null && root.right == null) {
                if (isPalindrome(valuesTracker))
                    result++;
            }
            dfs(root.left, valuesTracker);
            dfs(root.right, valuesTracker);
            valuesTracker[root.val] = valuesTracker[root.val] - 1;
        }

        boolean isPalindrome(int[] map) {
            int miss = 0;
            for (int i = 0; i < 10; i++) {
                if (map[i] % 2 != 0)
                    miss++;
                if (miss > 1)
                    return false;
            }
            return true;
        }
    }
}
