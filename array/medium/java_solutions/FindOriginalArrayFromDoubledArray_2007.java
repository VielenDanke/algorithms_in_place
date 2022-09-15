package array.medium.java_solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindOriginalArrayFromDoubledArray_2007 {

    // Time O(N * logN) | Space O(N)
    static class Solution {
        public int[] findOriginalArray(int[] changed) {
            if (changed == null || changed.length == 0 || changed.length % 2 == 1) return new int[]{};
            int len = changed.length;
            Arrays.sort(changed);

            Map<Integer, Integer> pairCounter = new HashMap<>();

            for (int num : changed) {
                pairCounter.put(num, pairCounter.getOrDefault(num, 0) + 1);
            }
            int[] result = new int[len / 2];
            int idx = 0;
            for (int num : changed) {
                if (!pairCounter.containsKey(num) || !pairCounter.containsKey(num * 2)) {
                    continue;
                }
                if (num == 0) {
                    int amount = pairCounter.get(num);
                    if (amount - 2 == 0) {
                        pairCounter.remove(num);
                    } else {
                        pairCounter.put(num, amount - 2);
                    }
                    idx++;
                } else {
                    int amount = pairCounter.get(num);
                    int doubleAmount = pairCounter.get(num * 2);
                    if (amount - 1 < 0 || doubleAmount - 1 < 0) {
                        return new int[]{};
                    }
                    if (amount - 1 == 0) {
                        pairCounter.remove(num);
                    } else {
                        pairCounter.put(num, amount - 1);
                    }
                    if (doubleAmount - 1 == 0) {
                        pairCounter.remove(num * 2);
                    } else {
                        pairCounter.put(num * 2, doubleAmount - 1);
                    }
                    result[idx++] = num;
                }
            }
            return pairCounter.isEmpty() ? result : new int[]{};
        }
    }

    static class SolutionTreeMap {
        public int[] findOriginalArray(int[] changed) {
            int len = changed.length;
            if (len % 2 == 1) return new int[]{};
            int idx = 0;
            int[] res = new int[len / 2];
            Map<Integer, Integer> pairCounter = new TreeMap<>();
            for (int num : changed) pairCounter.put(num, pairCounter.getOrDefault(num, 0) + 1);
            for (int num : pairCounter.keySet()) {
                if (pairCounter.get(num) > pairCounter.getOrDefault(num * 2, 0)) {
                    return new int[]{};
                }
                for (int j = 0; j < pairCounter.get(num); j++) {
                    res[idx++] = num;
                    pairCounter.put(num * 2, pairCounter.get(num * 2) - 1);
                }
            }
            return res;
        }
    }

    static class SolutionBruteForce {
        public int[] findOriginalArray(int[] changed) {
            Arrays.sort(changed);
            int len = changed.length;

            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (changed[i] * 2 == changed[j]) {
                        changed[j] = -1 << 30;
                        break;
                    }
                }
            }
            int[] result = new int[len / 2];
            int idx = 0;
            for (int j : changed) {
                if (j != -1 << 30) {
                    if (idx >= len / 2) return new int[]{};
                    result[idx++] = j;
                }
            }
            return result;
        }
    }
}
