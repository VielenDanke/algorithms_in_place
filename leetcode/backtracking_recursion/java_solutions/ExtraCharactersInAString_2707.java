package leetcode.backtracking_recursion.java_solutions;

import java.util.*;

public class ExtraCharactersInAString_2707 {

    static class Solution {
        private Set<String> set;
        private Map<String, Integer> memo;

        public int minExtraChar(String s, String[] dictionary) {
            memo = new HashMap<>();
            collectToSet(dictionary);
            return backtrack(s);
        }

        private int backtrack(String s) {
            if (s.isEmpty()) {
                return 0;
            }
            if (memo.containsKey(s)) return memo.get(s);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < s.length(); i++) {
                String newS = s.substring(0, i + 1);
                if (set.contains(newS)) {
                    min = Math.min(min, backtrack(s.substring(i + 1)));
                }
            }
            min = Math.min(min, 1 + backtrack(s.substring(1)));
            memo.put(s, min);
            return min;
        }

        private void collectToSet(String[] dict) {
            set = new HashSet<>();
            Collections.addAll(set, dict);
        }
    }

    static class SolutionTrie {
        private static class TreeNode {
            private boolean isWord;
            private final TreeNode[] children;

            private TreeNode() {
                isWord = false;
                children = new TreeNode[26];
            }
        }

        private Map<String, Integer> memo;

        public int minExtraChar(String s, String[] dictionary) {
            TreeNode root = buildTree(dictionary);
            memo = new HashMap<>();
            return backtrack(root, s);
        }

        private int backtrack(TreeNode root, String s) {
            if (s.isEmpty()) return 0;
            if (memo.containsKey(s)) return memo.get(s);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < s.length(); i++) {
                String str = s.substring(0, i + 1);
                if (contains(root, str)) {
                    min = Math.min(min, backtrack(root, s.substring(i + 1)));
                }
            }
            min = Math.min(min, 1 + backtrack(root, s.substring(1)));
            memo.put(s, min);
            return min;
        }

        private TreeNode buildTree(String[] dict) {
            TreeNode node = new TreeNode();

            for (String d : dict) {
                insert(node, d);
            }
            return node;
        }

        private void insert(TreeNode node, String word) {
            TreeNode temp = node;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TreeNode();
                }
                temp = temp.children[c - 'a'];
            }
            temp.isWord = true;
        }

        private boolean contains(TreeNode node, String s) {
            TreeNode temp = node;
            for (char c : s.toCharArray()) {
                if (temp.children[c - 'a'] == null) return false;
                temp = temp.children[c - 'a'];
            }
            return temp.isWord;
        }
    }
}
