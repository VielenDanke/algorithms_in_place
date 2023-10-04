package leetcode.backtracking_recursion.java_solutions;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor_2038 {

    static class Solution {
        public boolean winnerOfGame(String colors) {
            int aliceScore = 0;
            int bobScore = 0;

            for (int i = 1; i < colors.length() - 1; i++) {
                char current = colors.charAt(i);
                char left = colors.charAt(i - 1);
                char right = colors.charAt(i + 1);

                if (current == 'A' && left == 'A' && right == 'A') {
                    aliceScore++;

                } else if (current == 'B' && left == 'B' && right == 'B') {
                    bobScore++;
                }
            }
            return aliceScore > bobScore;
        }
    }

    static class SolutionBruteForce {
        public boolean winnerOfGame(String colors) {
            return makeMove(colors, true);
        }

        private boolean makeMove(String colors, boolean turn) {
            boolean isHit = false;
            if (turn) {
                for (int i = 0; i < colors.length(); i++) {
                    if (i != 0 && i != colors.length() - 1) {
                        char left = colors.charAt(i - 1);
                        char right = colors.charAt(i + 1);
                        char current = colors.charAt(i);
                        if (left == 'A' && right == 'A' && current == 'A') {
                            isHit = true;
                            if (makeMove(colors.substring(0, i) + colors.substring(i + 1), false)) {
                                return true;
                            }
                        }
                    }
                }
            } else {
                for (int i = 0; i < colors.length(); i++) {
                    if (i != 0 && i != colors.length() - 1) {
                        char left = colors.charAt(i - 1);
                        char right = colors.charAt(i + 1);
                        char current = colors.charAt(i);
                        if (left == 'B' && right == 'B' && current == 'B') {
                            isHit = true;
                            if (makeMove(colors.substring(0, i) + colors.substring(i + 1), true)) {
                                return true;
                            }
                        }
                    }
                }
            }
            if (!isHit) {
                return !turn;
            }
            return false;
        }
    }
    }
}
