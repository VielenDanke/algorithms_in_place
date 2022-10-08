package leetcode.structures.java_solutions;

import java.util.HashMap;
import java.util.Map;

/*
Python solution

class TrieNode:
    def __init__(self):
        self.children = {}

class Trie:

    def __init__(self):
        self.root = TrieNode()


    def insert(self, word: str) -> None:
        node = self.root

        for i, letter in enumerate(word):
            if letter not in node.children:
                node.children[letter] = TrieNode()
            node = node.children[letter]
        node.children['*'] = None


    def search(self, word: str) -> bool:
        node = self.root

        for i, letter in enumerate(word):
            if letter not in node.children:
                return False
            node = node.children[letter]
        return '*' in node.children


    def startsWith(self, prefix: str) -> bool:
        node = self.root

        for i, letter in enumerate(prefix):
            if letter not in node.children:
                return False
            node = node.children[letter]
        return True
 */

public class PrefixTrie_208 {

    public static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    public static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++) {
                insertIntoSuffixTrie(str, i);
            }
        }

        public boolean contains(String str) {
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!node.children.containsKey(letter)) {
                    return false;
                }
                node = node.children.get(letter);
            }
            return true;
        }

        public boolean hasIntersections(String str) {
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (root.children.containsKey(letter)) {
                    return true;
                }
            }
            return false;
        }

        private void insertIntoSuffixTrie(String str, int i) {
            TrieNode node = root;
            for (int j = i; j < str.length(); j++) {
                char letter = str.charAt(j);
                if (!node.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                }
                node = node.children.get(letter);
            }
            node.children.put(endSymbol, null);
        }
    }
}
