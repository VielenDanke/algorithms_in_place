package leetcode.dynamic_programming.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class CountWaysToBuildGoodStrings_2466 {

    private static final int MOD = 1000000007;

    static class SolutionUsingMap {
        private int low, high, zero, one;
        private Map<Integer, Integer> cache;

        public int countGoodStrings(int low, int high, int zero, int one) {
            this.cache = new HashMap<>();
            this.low = low;
            this.high = high;
            this.zero = zero;
            this.one = one;
            return construct(0);
        }

        private int construct(int temp) {
            int count = 0;
            if (cache.containsKey(temp)) return cache.get(temp);
            if (temp > high) {
                return count;
            }
            if (temp >= low) {
                count++;
            }
            count += construct(temp + zero) % MOD;
            count += construct(temp + one) % MOD;
            count %= MOD;
            cache.put(temp, count);
            return count;
        }
    }

    static class SolutionUsingArray {
        private int low, high, zero, one;
        private Integer[] cache;

        public int countGoodStrings(int low, int high, int zero, int one) {
            this.cache = new Integer[1000000];
            this.low = low;
            this.high = high;
            this.zero = zero;
            this.one = one;
            return construct(0);
        }

        private int construct(int temp) {
            int count = 0;
            if (cache[temp] != null) return cache[temp];
            if (temp > high) {
                return count;
            }
            if (temp >= low) {
                count++;
            }
            count += construct(temp + zero) % MOD;
            count += construct(temp + one) % MOD;
            return cache[temp] = count % MOD;
        }
    }

    static class SolutionBruteForce {
        private int low, high;
        private String toAppendZero, toAppendOne;
        private Integer[] cache;

        public int countGoodStrings(int low, int high, int zero, int one) {
            this.cache = new Integer[100000];
            this.low = low;
            this.high = high;
            toAppendZero = "0".repeat(Math.max(0, zero));
            toAppendOne = "1".repeat(Math.max(0, one));
            return construct("");
        }

        private int construct(String temp) {
            int count = 0;
            if (cache[temp.length()] != null) return cache[temp.length()];
            if (temp.length() > high) {
                return count;
            }
            if (temp.length() >= low) {
                count++;
            }
            count += construct(temp + toAppendZero) % MOD;
            count += construct(temp + toAppendOne) % MOD;
            return cache[temp.length()] = count % MOD;
        }
    }
}
