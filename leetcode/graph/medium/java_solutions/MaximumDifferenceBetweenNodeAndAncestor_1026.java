package leetcode.graph.medium.java_solutions;

import static leetcode.tree.Helper.*;

/*
Rust

use std::rc::Rc;
use std::cell::RefCell;
impl Solution {
    pub fn max_ancestor_diff(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        if let Some(root_node) = root {
            let mut diff = 0;
            let mut min = root_node.borrow().val;
            let mut max = root_node.borrow().val;
            Solution::dfs(&root_node, &mut diff, min, max);
            diff
        } else {
            0
        }
    }

    fn dfs(root: &Rc<RefCell<TreeNode>>, diff: &mut i32, mut min: i32, mut max: i32) {
        let root_val = root.borrow().val;
        *diff = (*diff).max((min - root_val).abs()).max((max - root_val).abs());
        min = min.min(root_val);
        max = max.max(root_val);

        if let Some(left) = &root.borrow().left {
            Solution::dfs(left, diff, min, max);
        }
        if let Some(right) = &root.borrow().right {
            Solution::dfs(right, diff, min, max);
        }
    }
}
 */

public class MaximumDifferenceBetweenNodeAndAncestor_1026 {

    static class SolutionTopDown {

        public int diff = 0;

        public int maxAncestorDiff(TreeNode root) {
            if (root == null) return 0;
            int min = root.val, max = root.val;
            dfs(root, min, max);
            return diff;
        }

        public void dfs(TreeNode root, int min, int max) {
            if (root == null) return;
            diff = Math.max(diff, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
            min = Math.min(min, root.val);
            max = Math.max(max, root.val);
            dfs(root.left, min, max);
            dfs(root.right, min, max);
        }
    }

    static class SolutionDownTop {
        private int maxDiff = -1 << 30;

        public int maxAncestorDiff(TreeNode root) {
            dfs(root);
            return maxDiff;
        }

        private int[] dfs(TreeNode node) {
            if (node.left == null && node.right == null) {
                return new int[]{node.val, node.val};
            }
            int[] temp = new int[]{1 << 30, -1 << 30};

            if (node.left != null) {
                int[] tempLeft = dfs(node.left);
                temp[0] = Math.min(temp[0], tempLeft[0]);
                temp[1] = Math.max(temp[1], tempLeft[1]);
            }
            if (node.right != null) {
                int[] tempRight = dfs(node.right);
                temp[0] = Math.min(temp[0], tempRight[0]);
                temp[1] = Math.max(temp[1], tempRight[1]);
            }
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(node.val - temp[0]), Math.abs(node.val - temp[1])));
            return new int[]{Math.min(node.val, temp[0]), Math.max(node.val, temp[1])};
        }
    }
}
