package leetcode.strings.medium.java_solutions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {

    static class SolutionMemo {
        private Set<String> set;
        private Boolean[] memo;

        public boolean wordBreak(String s, List<String> wordDict) {
            this.set = new HashSet<>(wordDict);
            this.memo = new Boolean[s.length()];
            return backtrack(s, 0);
        }

        private boolean backtrack(String s, int start) {
            if (start >= s.length()) {
                return true;
            }
            if (memo[start] != null) return memo[start];
            for (int i = start; i <= s.length(); i++) {
                if (set.contains(s.substring(start, i))) {
                    memo[start] = backtrack(s, i);
                    if (memo[start]) {
                        return true;
                    }
                }
            }
            return memo[start] = false;
        }
    }

    static class SolutionSet {
        private Set<String> set;

        public boolean wordBreak(String s, List<String> wordDict) {
            this.set = new HashSet<>(wordDict);
            return backtrack(s);
        }

        private boolean backtrack(String s) {
            if (s.isEmpty()) {
                return true;
            }
            for (int i = 0; i <= s.length(); i++) {
                if (set.contains(s.substring(0, i))) {
                    if (backtrack(s.substring(i))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static class SolutionTrie {
        private static class Trie {
            private boolean isWord;
            private final Trie[] letters;

            private Trie() {
                this.isWord = false;
                this.letters = new Trie[26];
            }
        }

        private final Trie root = new Trie();

        public boolean wordBreak(String s, List<String> wordDict) {
            for (String word : wordDict) {
                insertToTrie(word);
            }
            return backtrack(s);
        }

        private boolean backtrack(String s) {
            if (s.isEmpty()) {
                return true;
            }
            for (int i = 0; i <= s.length(); i++) {
                if (isSegmentExists(s.substring(0, i))) {
                    if (backtrack(s.substring(i))) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isSegmentExists(String s) {
            Trie temp = root;
            for (char c : s.toCharArray()) {
                if (temp.letters[c - 'a'] == null) return false;
                temp = temp.letters[c - 'a'];
            }
            return temp.isWord;
        }

        private void insertToTrie(String s) {
            Trie temp = root;
            for (char c : s.toCharArray()) {
                if (temp.letters[c - 'a'] == null) {
                    temp.letters[c - 'a'] = new Trie();
                }
                temp = temp.letters[c - 'a'];
            }
            temp.isWord = true;
        }
    }

    public static void main(String[] args) {
        new SolutionTrie().wordBreak("leetcode", List.of("leet", "code"));
    }
}
