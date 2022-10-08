package leetcode.system_implementations.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class PrefixTrie_208 {

    private static class Trie {

        private static class TrieNode {
            Map<Character, TrieNode> children;

            TrieNode() {
                this.children = new HashMap<>();
            }
        }

        private final TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char current = word.charAt(i);
                if (!node.children.containsKey(current)) {
                    node.children.put(current, new TrieNode());
                }
                node = node.children.get(current);
            }
            node.children.put('*', null);
        }

        public boolean search(String word) {
            TrieNode node = dfs(word);
            return node != null && node.children.containsKey('*');
        }

        public boolean startsWith(String prefix) {
            return dfs(prefix) != null;
        }

        private TrieNode dfs(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char current = word.charAt(i);
                if (!node.children.containsKey(current)) {
                    return null;
                }
                node = node.children.get(current);
            }
            return node;
        }
    }
}
