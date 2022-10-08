package leetcode.strings.medium.java_solutions;

import java.util.*;

public class ShortEncodingWords_820 {

    public int minimumLengthEncodingSet(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                String current = word.substring(i);
                if (set.contains(current)) {
                    set.remove(current);
                }
            }
        }
        return set.stream().mapToInt(str -> str.length() + 1).sum();
    }

    // -------------------------------------------------------------------------------------

    public int minimumLengthEncodingSort(String[] words) {
        int N = words.length;

        StringBuilder result = new StringBuilder();

        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = N - 1; i >= 0; i--) {
            String currentWord = words[i] + "#";
            if (result.indexOf(currentWord) == -1) result.append(currentWord);
        }
        return result.length();
    }

    // -------------------------------------------------------------------------------------

    private static class Trie {
        TrieNode root = new TrieNode();

        public void insert(String str) {
            for (int i = 0; i < str.length(); i++) {
                insertIntoTrieNode(str, i);
            }
        }

        public void insertIntoTrieNode(String str, int startIdx) {
            TrieNode node = root;
            for (int i = startIdx; i < str.length(); i++) {
                char current = str.charAt(i);
                if (!node.children.containsKey(current)) {
                    node.children.put(current, new TrieNode());
                }
                node = node.children.get(current);
            }
            node.children.put('#', new TrieNode());
        }

        public boolean contains(String str) {
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                char current = str.charAt(i);
                if (!node.children.containsKey(current)) {
                    return false;
                }
                node = node.children.get(current);
            }
            return true;
        }
    }

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    public int minimumLengthEncodingTrie(String[] words) {
        Trie trie = new Trie();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = words.length - 1; i >= 0; i--) {
            if (!trie.contains(words[i] + "#")) {
                trie.insert(words[i]);
            } else {
                words[i] = null;
            }
        }
        int sum = 0;
        for (String word : words) {
            if (word != null) {
                sum += word.length() + 1;
            }
        }
        return sum;
    }

    // -------------------------------------------------------------------------------------

    public int minimumLengthEncoding(String[] words) {
        int N = words.length;

        for (int i = 0; i < N; i++) {
            words[i] = words[i] + "#";
        }
        boolean[] absorbed = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!absorbed[i]) {
                for (int j = 0; j < N; j++) {
                    if (i != j && !absorbed[j]) {
                        if (words[i].contains(words[j])) {
                            absorbed[j] = true;
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (!absorbed[i]) result += words[i].length();
        }
        return result;
    }
}
