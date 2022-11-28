package leetcode.bit_manipulation.java_solutions;

import java.util.HashMap;
import java.util.TreeMap;

public class NumberComplement_476 {

    static class Solution {
        public int findComplement(int num) {
            return ~num & ((Integer.highestOneBit(num) << 1) - 1);
        }
    }

    static class SolutionMathPow {
        public int findComplement(int num) {
            int i = 0, j = 0;
            while (i < num) {
                i += Math.pow(2, j);
                j++;
            }
            return i - num;
        }
    }

    static class SolutionString {
        public int findComplement(int num) {
            char[] chars = Integer.toBinaryString(num).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    chars[i] = '0';
                } else {
                    chars[i] = '1';
                }
            }
            return Integer.parseInt(new String(chars), 2);
        }
    }
}
