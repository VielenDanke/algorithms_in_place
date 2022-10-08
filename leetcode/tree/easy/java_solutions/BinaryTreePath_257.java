package leetcode.tree.easy.java_solutions;

import java.util.ArrayList;
import java.util.List;

import static leetcode.tree.Helper.TreeNode;

public class BinaryTreePath_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String s, List<String> result) {
        if (node.left == null && node.right == null) {
            s += node.val;
            result.add(s);
            return;
        }
        s += String.format("%d->", node.val);
        if (node.left != null) {
            dfs(node.left, s, result);
        }
        if (node.right != null) {
            dfs(node.right, s, result);
        }
    }
}
