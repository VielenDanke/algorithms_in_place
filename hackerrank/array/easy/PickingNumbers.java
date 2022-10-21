package hackerrank.array.easy;

import java.util.*;

public class PickingNumbers {

    // https://www.hackerrank.com/challenges/picking-numbers

    static class SolutionSort {
        public static int pickingNumbers(List<Integer> a) {
            // Write your code here
            Collections.sort(a);
            int length = 1;
            int max = 0;
            int elem = a.get(0);
            for (int i = 1; i < a.size(); i++) {
                if (Math.abs(elem - a.get(i)) <= 1) {
                    length++;
                    max = Math.max(length, max);
                } else {
                    elem = a.get(i);
                    length = 1;
                }
            }
            return max;
        }

    }

    static class SolutionBruteForce {
        private static Integer max;

        public static int pickingNumbers(List<Integer> a) {
            // Write your code here
            max = Integer.MIN_VALUE;
            for (int i = 0; i < a.size(); i++) {
                backtrack(a, new Integer[]{a.get(i), null}, i + 1, 1);
            }
            return max;
        }


        private static void backtrack(List<Integer> a, Integer[] pair, int idx, int counter) {
            if (idx >= a.size()) return;

            max = Math.max(max, counter);

            for (int i = idx; i < a.size(); i++) {
                int diff = Math.abs(a.get(i) - pair[0]);
                if (diff <= 1) {
                    if (pair[1] == null) {
                        pair[1] = a.get(idx);
                        backtrack(a, pair, idx + 1, counter + 1);
                        pair[1] = null;
                    } else {
                        int secDiff = Math.abs(a.get(idx) - pair[1]);
                        if (secDiff <= 1) {
                            backtrack(a, pair, idx + 1, counter + 1);
                        }
                    }
                } else {
                    backtrack(a, pair, idx + 1, counter);
                }
            }
        }
    }

    static class SolutionAllCombinations {
        private static Integer max;

        public static int pickingNumbers(List<Integer> a) {
            // Write your code here
            max = Integer.MIN_VALUE;
            backtrack(a, new ArrayList<>(), 0);
            return max;
        }

        public static void backtrack(List<Integer> a, List<Integer> temp, int start) {
            if (temp.size() >= 2 && max < temp.size()) {
                if (!isValid(temp)) {
                    return;
                }
                max = temp.size();
            }
            for (int i = start; i < a.size(); i++) {
                temp.add(a.get(i));
                backtrack(a, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }

        private static boolean isValid(List<Integer> temp) {
            int maxDiff = 0;
            for (int i = 0; i < temp.size(); i++) {
                for (int j = 0; j < temp.size(); j++) {
                    if (i != j) {
                        maxDiff = Math.max(maxDiff, Math.abs(temp.get(i) - temp.get(j)));
                    }
                }
            }
            return maxDiff <= 1;
        }
    }
}
