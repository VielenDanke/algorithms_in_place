package leetcode.strings.hard.java_solutions;

import java.util.LinkedList;
import java.util.List;

public class WordSearch2_212 {

    static class Solution {

        private static class TrieNode {
            String word = null;
            TrieNode[] children = new TrieNode[26];
        }

        private static class Trie {
            private final TrieNode root;

            private Trie() {
                this.root = new TrieNode();
            }

            void addWord(String word) {
                TrieNode temp = root;
                for (int i = 0; i < word.length(); i++) {
                    char current = word.charAt(i);
                    int idx = current - 'a';
                    if (temp.children[idx] == null) {
                        temp.children[idx] = new TrieNode();
                    }
                    temp = temp.children[idx];
                }
                temp.word = word;
            }
        }

        private int n;
        private int m;

        public List<String> findWords(char[][] board, String[] words) {
            List<String> list = new LinkedList<>();
            n = board.length;
            m = board[0].length;
            Trie trie = new Trie();
            for (String word : words) {
                trie.addWord(word);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    isBoardContainsWord(list, board, i, j, trie.root);
                }
            }
            return list;
        }

        private void isBoardContainsWord(List<String> list, char[][] board, int row, int col, TrieNode node) {
            if (isBoardersViolated(row, col)) {
                return;
            }
            char current = board[row][col];
            if (current == '#') {
                return;
            }
            TrieNode child = node.children[current - 'a'];
            if (child == null) {
                return;
            }
            if (child.word != null) {
                list.add(child.word);
                child.word = null;
            }
            board[row][col] = '#';
            isBoardContainsWord(list, board, row + 1, col, child);
            isBoardContainsWord(list, board, row - 1, col, child);
            isBoardContainsWord(list, board, row, col + 1, child);
            isBoardContainsWord(list, board, row, col - 1, child);
            board[row][col] = current;
        }

        private boolean isBoardersViolated(int row, int col) {
            return row < 0 || col < 0 || row >= n || col >= m;
        }
    }

    static class SolutionBruteForce {
        private int n;
        private int m;

        public List<String> findWords(char[][] board, String[] words) {
            n = board.length;
            m = board[0].length;
            List<String> list = new LinkedList<>();

            for (String word : words) {
                loop:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (isBoardContainsWord(board, i, j, word, 0, new boolean[n][m])) {
                            list.add(word);
                            break loop;
                        }
                    }
                }
            }
            return list;
        }

        private boolean isBoardContainsWord(char[][] board, int row, int col, String word, int idx, boolean[][] visited) {
            if (idx >= word.length()) {
                return true;
            }
            if (isBoardersViolated(row, col)) {
                return false;
            }
            if (visited[row][col]) {
                return false;
            }
            char current = word.charAt(idx);
            if (current != board[row][col]) {
                return false;
            }
            visited[row][col] = true;
            boolean isBoardContains = isBoardContainsWord(board, row + 1, col, word, idx + 1, visited) ||
                    isBoardContainsWord(board, row - 1, col, word, idx + 1, visited) ||
                    isBoardContainsWord(board, row, col + 1, word, idx + 1, visited) ||
                    isBoardContainsWord(board, row, col - 1, word, idx + 1, visited);
            visited[row][col] = false;
            return isBoardContains;
        }

        private boolean isBoardersViolated(int row, int col) {
            return row < 0 || col < 0 || row >= n || col >= m;
        }
    }
}
