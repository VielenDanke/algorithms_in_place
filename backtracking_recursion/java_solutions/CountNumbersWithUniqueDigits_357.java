package backtracking_recursion.java_solutions;

public class CountNumbersWithUniqueDigits_357 {

    static class SolutionMath {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) return 1;
            int res = 10;
            int uniqueDigits = 9;
            int availableNumber = 9;
            while (n-- > 1 && availableNumber > 0) {
                uniqueDigits = uniqueDigits * availableNumber;
                res += uniqueDigits;
                availableNumber--;
            }
            return res;
        }
    }

    static class SolutionWithoutBuilder {
        public int countNumbersWithUniqueDigits(int n) {
            return backtrack(0, new boolean[10], n);
        }

        private int backtrack(int d, boolean[] used, int n) {
            if (d == n) return 1;
            int total = 1;
            for (int i = (d == 0) ? 1 : 0; i <= 9; i++) {
                if (!used[i]) {
                    used[i] = true;
                    total += backtrack(d + 1, used, n);
                    used[i] = false;
                }
            }
            return total;
        }
    }

    static class Solution {
        private int counter;

        public int countNumbersWithUniqueDigits(int n) {
            counter = 0;
            backtrack(new StringBuilder(), new boolean[10], n);
            return ++counter;
        }

        private void backtrack(StringBuilder num, boolean[] used, int n) {
            if (num.length() > n) return;
            if (num.length() > 0) {
                counter++;
            }
            for (int i = 0; i <= 9; i++) {
                if (num.length() == 0 && i == 0 || used[i]) {
                    continue;
                }
                num.append(i);
                used[i] = true;
                backtrack(num, used, n);
                num.deleteCharAt(num.length() - 1);
                used[i] = false;
            }
        }
    }
}
