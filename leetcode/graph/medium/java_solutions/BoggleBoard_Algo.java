package leetcode.graph.medium.java_solutions;

import java.util.*;

public class BoggleBoard_Algo {

    // Common methods and variables
    private static final int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    private static Set<String> foundSet;

    private static List<String> filterList(List<String> words, char[][] board, int row, int col, int nextIdx) {
        List<String> filteredList = new ArrayList<>();
        for (String word : words) {
            if (word.length() > nextIdx && word.charAt(nextIdx) == board[row][col] && !foundSet.contains(word)) {
                filteredList.add(word);
            }
        }
        return filteredList;
    }

    private static boolean isCrossingBoarder(char[][] board, int row, int col) {
        return row < 0 || col < 0 || row >= board.length || col >= board[row].length;
    }

    // --------------------------------------------------------------------------------------------------------------

    public static List<String> boggleBoard(char[][] board, String[] words) {
        // Write your code here.
        List<String> resultWords = new ArrayList<>();
        if (board == null || board.length == 0) {
            return resultWords;
        }
        int rowLength = board.length;
        int colLength = board[0].length;
        List<String> wordsList = Arrays.asList(words);
        foundSet = new HashSet<>();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                explore(resultWords, board, i, j, 0, wordsList, new boolean[rowLength][colLength]);
            }
        }
        return resultWords;
    }

    private static void explore(List<String> resultWords, char[][] board, int row, int col, int nextIdx, List<String> words, boolean[][] visited) {
        List<String> filteredWords = filterList(words, board, row, col, nextIdx);
        if (filteredWords.size() == 0) {
            return;
        }
        for (String w : filteredWords) {
            if (w.length() == nextIdx + 1) {
                resultWords.add(w);
                foundSet.add(w);
            }
        }
        visited[row][col] = true;
        for (int[] direction : DIR) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (isCrossingBoarder(board, nextRow, nextCol) || visited[nextRow][nextCol]) {
                continue;
            }
            visited[nextRow][nextCol] = true;
            explore(resultWords, board, nextRow, nextCol, nextIdx + 1, filteredWords, visited);
            visited[nextRow][nextCol] = false;
        }
    }


    // -------------------------------------------------------------------------------------------------------------

    public static List<String> boggleBoardBetter(char[][] board, String[] words) {
        // Write your code here.
        List<String> resultWords = new ArrayList<>();
        if (board == null || board.length == 0) {
            return resultWords;
        }
        int rowLength = board.length;
        int colLength = board[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                for (int k = 0; k < words.length; k++) {
                    String word = words[k];
                    if (word != null && word.charAt(0) == board[i][j]) {
                        boolean[][] visited = new boolean[rowLength][colLength];
                        visited[i][j] = true;
                        if (explore(resultWords, board, i, j, 0, word, visited)) {
                            words[k] = null;
                        }
                    }
                }
            }
        }
        return resultWords;
    }

    private static boolean explore(List<String> resultWords, char[][] board, int row, int col, int nextIdx, String word, boolean[][] visited) {
        if (word.length() == nextIdx || word.charAt(nextIdx) != board[row][col]) {
            return false;
        }
        if (word.length() == nextIdx + 1 && word.charAt(nextIdx) == board[row][col]) {
            resultWords.add(word);
            return true;
        }
        for (int[] direction : DIR) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (isCrossingBoarder(board, nextRow, nextCol) || visited[nextRow][nextCol]) {
                continue;
            }
            visited[nextRow][nextCol] = true;
            if (explore(resultWords, board, nextRow, nextCol, nextIdx + 1, word, visited)) {
                return true;
            }
            visited[nextRow][nextCol] = false;
        }
        return false;
    }
}
