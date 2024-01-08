package leetcode.graph.easy.java_solutions;

import java.util.LinkedList;
import java.util.Queue;

import static leetcode.tree.Helper.TreeNode;

public class RangeSumOfBst_938 {

    /*
    // Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
//
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }
use std::rc::Rc;
use std::cell::RefCell;
use std::collections::VecDeque;

impl Solution {
    pub fn range_sum_bst(root: Option<Rc<RefCell<TreeNode>>>, low: i32, high: i32) -> i32 {
        let mut stack: VecDeque<Option<Rc<RefCell<TreeNode>>>> = VecDeque::new();

        stack.push_back(root);

        let mut sum: i32 = 0;

        while let Some(stack_object) = stack.pop_front() {
            let node = stack_object.as_ref().unwrap().replace(TreeNode::new(0));
            if node.val >= low && node.val <= high {
                sum += node.val;
            }
            if node.val > low && node.left.is_some() {
                stack.push_back(node.left);
            }
            if node.val < high && node.right.is_some() {
                stack.push_back(node.right);
            }
        }
        sum
    }
}
     */

    static class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            int sum = 0;

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node == null) continue;

                if (node.val >= low && node.val <= high) {
                    sum += node.val;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            return sum;
        }
    }
}
