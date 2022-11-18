package hackerrank.backtrack.medium.java_solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NonDivisibleSubset {

    static class SolutionBacktrack {
        private static int maxSize = 0;

        public static int nonDivisibleSubset(int k, List<Integer> s) {
            // Write your code here
            backtrack(s, new ArrayList<>(), 0, k);
            return maxSize;
        }

        private static void backtrack(List<Integer> s, List<Integer> temp, int start, int k) {
            if (isSubsetNonDivisible(temp, k)) {
                maxSize = Math.max(maxSize, temp.size());
            }
            for (int i = start; i < s.size(); i++) {
                temp.add(s.get(i));
                backtrack(s, temp, i + 1, k);
                temp.remove(temp.size() - 1);
            }
        }

        private static boolean isSubsetNonDivisible(List<Integer> temp, int k) {
            int n = temp.size();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    Integer v1 = temp.get(i);
                    Integer v2 = temp.get(j);
                    if (!v1.equals(v2) && (v1 + v2) % k == 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
