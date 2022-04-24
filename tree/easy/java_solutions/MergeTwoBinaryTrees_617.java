package tree.easy.java_solutions;

import tree.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeTwoBinaryTrees_617 {

    public Helper.TreeNode mergeTrees(Helper.TreeNode root1, Helper.TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public Helper.TreeNode mergeTreesUsingStack(Helper.TreeNode root1, Helper.TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        Stack<List<Helper.TreeNode>> stack = new Stack<>();

        stack.add(new ArrayList<>() {{
            add(root1);
            add(root2);
        }});

        while (stack.size() > 0) {
            List<Helper.TreeNode> nodes = stack.pop();
            if (nodes.get(0) == null || nodes.get(1) == null) {
                continue;
            }
            nodes.get(0).val += nodes.get(1).val;

            if (nodes.get(0).left == null) {
                nodes.get(0).left = nodes.get(1).left;
            } else {
                stack.add(new ArrayList<>() {{
                    add(nodes.get(0).left);
                    add(nodes.get(1).left);
                }});
            }
            if (nodes.get(0).right == null) {
                nodes.get(0).right = nodes.get(1).right;
            } else {
                stack.add(new ArrayList<>() {{
                    add(nodes.get(0).right);
                    add(nodes.get(1).right);
                }});
            }
        }
        return root1;
    }
}
