package leetcode.array.medium.java_solutions;

public class MinimumPenaltyForAShop_2483 {

    static class SolutionBruteFoce {
        public int bestClosingTime(String customers) {
            int n = customers.length(), minPenalty = Integer.MAX_VALUE, idx = -1;
            for (int i = 0; i < n + 1; i++) {
                int currPenalty = 0;
                for (int j = i; j < n; j++) {
                    if (customers.charAt(j) == 'Y') {
                        currPenalty++;
                    } else {
                        currPenalty--;
                    }
                }
                if (minPenalty > currPenalty) {
                    minPenalty = currPenalty;
                    idx = i;
                }
            }
            return idx;
        }
    }

    static class Solution {
        public int bestClosingTime(String customers) {
            var currentPenalty = 0;
            var n = customers.length();

            for (var i = 0; i < n; i++) {
                if (customers.charAt(i) == 'Y') {
                    currentPenalty++;
                }
            }

            var minPenalty = currentPenalty;
            var earliestHour = 0;

            for (int i = 0; i < n; i++) {
                var ch = customers.charAt(i);

                if (ch == 'Y') {
                    currentPenalty--;
                } else {
                    currentPenalty++;
                }
                if (currentPenalty < minPenalty) {
                    earliestHour = i + 1;
                    minPenalty = currentPenalty;
                }
            }

            return earliestHour;
        }
    }
}
