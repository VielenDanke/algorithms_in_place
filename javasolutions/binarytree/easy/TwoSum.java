package javasolutions.binarytree.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import javasolutions.binarytree.TreeNode;

public class TwoSum {

    public static boolean twoSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();

        Set<Integer> vals = new HashSet<>();

        stack.add(root);

        while (stack.size() > 0) {
            TreeNode node = stack.pop();

            if (node == null) {
                continue;
            }
            if (vals.contains(sum - node.val)) {
                return true;
            }
            vals.add(node.val);
            stack.add(node.left);
            stack.add(node.right);
        }
        return false;
    }
}
