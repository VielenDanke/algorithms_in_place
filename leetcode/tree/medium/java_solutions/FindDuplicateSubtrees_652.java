package leetcode.tree.medium.java_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static leetcode.tree.Helper.TreeNode;

public class FindDuplicateSubtrees_652 {

    static class Solution {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            Map<String, Integer> hm = new HashMap<>();
            dfs(res, root, hm);
            return res;
        }

        public String dfs(List<TreeNode> res, TreeNode root, Map<String, Integer> hm) {
            if (root == null) return "";
            String left = dfs(res, root.left, hm);
            String right = dfs(res, root.right, hm);
            int rootVal = root.val;
            String formedStr = String.format("%d$%s$%s", rootVal, left, right);
            if (hm.getOrDefault(formedStr, 0) == 1) {
                res.add(root);
            }
            hm.put(formedStr, hm.getOrDefault(formedStr, 0) + 1);
            return formedStr;
        }
    }
}
