package leetcode.system_implementations.java_solutions;

public class DesignAddSearchWordsDataStructure_211 {

    static class WordDictionary {

        private static class TreeNode {
            private boolean isWord;
            private final TreeNode[] nodes;

            private TreeNode() {
                this.nodes = new TreeNode[26];
            }
        }

        private final TreeNode root;

        public WordDictionary() {
            this.root = new TreeNode();
        }

        public void addWord(String word) {
            TreeNode temp = root;
            for (char c : word.toCharArray()) {
                if (temp.nodes[c - 'a'] == null) {
                    temp.nodes[c - 'a'] = new TreeNode();
                }
                temp = temp.nodes[c - 'a'];
            }
            temp.isWord = true;
        }

        public boolean search(String word) {
            return searchDot(word, root, 0);
        }

        private boolean searchDot(String word, TreeNode temp, int idx) {
            if (temp == null) return false;
            if (idx >= word.length()) return temp.isWord;
            char c = word.charAt(idx);
            if (c == '.') {
                for (TreeNode node : temp.nodes) {
                    if (searchDot(word, node, idx + 1)) {
                        return true;
                    }
                }
                return false;
            }
            return searchDot(word, temp.nodes[c - 'a'], idx + 1);
        }
    }
}
