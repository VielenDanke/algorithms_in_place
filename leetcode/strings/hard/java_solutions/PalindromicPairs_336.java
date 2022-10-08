package leetcode.strings.hard.java_solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PalindromicPairs_336 {

    static class SolutionTrie {

        private static class TrieNode {
            Map<Character, TrieNode> children;
            Integer idx;

            TrieNode() {
                this.children = new HashMap<>();
            }

            TrieNode(Integer idx) {
                this.idx = idx;
                this.children = new HashMap<>();
            }
        }

        private static class Trie {
            TrieNode root;

            Trie() {
                this.root = new TrieNode();
            }

            void add(String word, int idx) {
                TrieNode temp = root;
                for (int i = 0; i < word.length(); i++) {
                    char current = word.charAt(i);
                    if (!temp.children.containsKey(current)) {
                        temp.children.put(current, new TrieNode(idx));
                    }
                    temp = temp.children.get(current);
                }
                temp.children.put('*', new TrieNode(idx));
            }

            Integer contains(String word) {
                TrieNode temp = root;
                for (int i = 0; i < word.length(); i++) {
                    char current = word.charAt(i);
                    if (!temp.children.containsKey(current)) {
                        return null;
                    }
                    temp = temp.children.get(current);
                }
                if (temp.children.containsKey('*')) {
                    return temp.children.get('*').idx;
                }
                return null;
            }

            Integer startsWith(String word) {
                TrieNode temp = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (!temp.children.containsKey(c)) {
                        return null;
                    }
                    temp = temp.children.get(c);
                }
                return temp.idx;
            }
        }

        public List<List<Integer>> palindromePairs(String[] words) {
            Trie trie = new Trie();
            Trie reversed = new Trie();

            for (int i = 0; i < words.length; i++) {
                trie.add(words[i], i);
                reversed.add(new StringBuilder(words[i]).reverse().toString(), i);
            }
            List<List<Integer>> result = new LinkedList<>();
            for (String word : words) {
                Integer left = trie.startsWith(word);
                Integer right = reversed.startsWith(word);
                if (left != null && right != null && (words[left].length() + words[right].length()) % 2 == 0) {
                    LinkedList<Integer> l = new LinkedList<>();
                    l.add(left);
                    l.add(right);
                    result.add(l);
                }
            }
            return result;
        }
    }

    static class Solution {
        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> result = new LinkedList<>();

            int n = words.length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && isPalindrome(words[i] + words[j])) {
                        List<Integer> list = new LinkedList<>();
                        list.add(i);
                        list.add(j);
                        result.add(list);
                    }
                }
            }
            return result;
        }

        private boolean isPalindrome(String word) {
            int left = 0, right = word.length() - 1;

            while (left < right) {
                if (word.charAt(left) != word.charAt(right)) return false;
                left++;
                right--;
            }
            return true;
        }
    }
}
