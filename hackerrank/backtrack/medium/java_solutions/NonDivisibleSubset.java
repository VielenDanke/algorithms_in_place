package hackerrank.backtrack.medium.java_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonDivisibleSubset {

    static class Solution {

        public static int nonDivisibleSubset(int k, List<Integer> s) {
            Map<Integer, Integer> map = new HashMap<>();

            for (Integer x : s) {
                map.put(x % k, map.getOrDefault(x % k, 0) + 1);
            }
            int result = 0;
            if (map.getOrDefault(0, 0) > 0) {
                result++;
            }
            for (int i = 1; i < k; i++) {
                if (map.getOrDefault(i, 0) == 0) {
                    continue;
                }
                if (i + i == k) {
                    result++;
                } else {
                    result += Math.max(map.getOrDefault(i, 0), map.getOrDefault(k - i, 0));
                    map.put(i, 0);
                    map.put(k - i, 0);
                }
            }
            return result;
        }
    }

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
