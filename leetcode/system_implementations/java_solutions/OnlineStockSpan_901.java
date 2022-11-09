package leetcode.system_implementations.java_solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OnlineStockSpan_901 {

    static class Solution {

        static class StockSpanner {
            private final Stack<int[]> stack;

            public StockSpanner(Stack<int[]> stack) {
                this.stack = stack;
            }

            public int next(int price) {
                int days = 1;
                while (!stack.isEmpty() && stack.peek()[0] <= price) {
                    days += stack.pop()[1];
                }
                stack.push(new int[]{price, days});
                return days;
            }
        }
    }

    static class SolutionBruteForce {

        static class StockSpanner {

            private final List<Integer> list;

            public StockSpanner() {
                this.list = new ArrayList<>();
            }

            public int next(int price) {
                if (list.isEmpty()) {
                    list.add(price);
                    return 1;
                } else {
                    int days = 1;
                    int idx = list.size() - 1;
                    while (idx >= 0 && list.get(idx) <= price) {
                        days++;
                        idx--;
                    }
                    list.add(price);
                    return days;
                }
            }
        }
    }
}
