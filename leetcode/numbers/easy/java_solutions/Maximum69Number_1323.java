package leetcode.numbers.easy.java_solutions;

import java.util.LinkedList;

public class Maximum69Number_1323 {

    static class Solution {

        public int maximum69Number(int num) {
            StringBuilder builder = new StringBuilder().append(num);
            int idx = builder.indexOf("6");
            if (idx == -1) return num;
            return Integer.parseInt(builder.replace(idx, idx + 1, "9").toString());
        }
    }

    static class SolutionNumber {

        public int maximum69Number(int num) {
            LinkedList<Integer> list = new LinkedList<>();

            while (num > 0) {
                list.add(num % 10);
                num /= 10;
            }
            double power = Math.pow(10, list.size() - 1);
            num = 0;
            boolean isFound = false;
            while (!list.isEmpty()) {
                int numToAdd = list.removeLast();
                if (numToAdd == 6 && !isFound) {
                    isFound = true;
                    numToAdd = 9;
                }
                num += numToAdd * power;
                power /= 10;
            }
            return num;
        }
    }
}
