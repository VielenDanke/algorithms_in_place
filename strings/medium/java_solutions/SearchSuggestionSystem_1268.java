package strings.medium.java_solutions;

import java.util.*;

public class SearchSuggestionSystem_1268 {

    public static class Trie {
        TrieNode root = new TrieNode();
        String word;

        Trie(String str) {
            word = str;
            for (int i = 0; i < str.length(); i++) {
                insertIntoTrieNode(str, i);
            }
        }

        private void insertIntoTrieNode(String str, int startIdx) {
            TrieNode root = this.root;

            for (int i = startIdx; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!root.children.containsKey(c)) {
                    root.children.put(c, new TrieNode());
                }
                root = root.children.get(c);
            }
        }

        public boolean contains(String str) {
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                char current = str.charAt(i);
                if (!node.children.containsKey(current)) return false;
                node = node.children.get(current);
            }
            return true;
        }
    }

    public static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    public List<List<String>> suggestedProductsWithTrie(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        int N = products.length;

        Trie[] tries = new Trie[N];
        for (int i = 0; i < N; i++) {
            tries[i] = new Trie(products[i]);
        }
        for (int i = 0; i < searchWord.length(); i++) {
            String s = searchWord.substring(0, i + 1);
            List<String> l = new ArrayList<>();
            for (Trie t : tries) {
                if (t.contains(s)) {
                    l.add(t.word);
                    if (l.size() == 3) {
                        break;
                    }
                }
            }
            result.add(l);
        }
        return result;
    }

    // -----------------------------------------------------------------------------------

    /*
    O(N * logN) time | O(N) space
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String word = searchWord.substring(0, i + 1);
            List<String> l = new ArrayList<>();
            for (String pr : products) {
                if (pr.startsWith(word)) {
                    l.add(pr);
                    if (l.size() >= 3) {
                        break;
                    }
                }
            }
            result.add(l);
        }
        return result;
    }
}
