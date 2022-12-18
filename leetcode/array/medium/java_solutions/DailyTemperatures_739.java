package leetcode.array.medium.java_solutions;

import java.util.*;

public class DailyTemperatures_739 {

    static class SolutionArray {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] stack = new int[temperatures.length];
            int top = -1;
            int[] result = new int[temperatures.length];
            for(int i = 0; i < temperatures.length; i++) {
                while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
                    int idx = stack[top--];
                    result[idx] = i - idx;
                }
                stack[++top] = i;
            }
            return result;
        }
    }

    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> stack = new Stack<>();
            int[] result = new int[temperatures.length];
            for(int i = 0; i < temperatures.length; i++) {
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int idx = stack.pop();
                    result[idx] = i - idx;
                }
                stack.push(i);
            }
            return result;
        }
    }

    static class SolutionTimeLimit {
        public int[] dailyTemperatures(int[] temperatures) {
            Map<Integer, List<Integer>> storage = new HashMap<>();
            int n = temperatures.length;

            for (int i = 0; i < n; i++) {
                storage.putIfAbsent(temperatures[i], new ArrayList<>());
                storage.get(temperatures[i]).add(i);
            }
            int[] result = new int[n];

            for (int i = 0; i < n; i++) {
                for (int j = temperatures[i] + 1; j <= 100; j++) {
                    if (storage.containsKey(j)) {
                        for (int idx : storage.get(j)) {
                            if (idx > i) {
                                if (result[i] != 0) {
                                    result[i] = Math.min(idx - i, result[i]);
                                } else {
                                    result[i] = idx - i;
                                }
                            }
                        }
                    }
                }
            }
            return result;
        }
    }

    static class SolutionBruteForce {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (temperatures[i] < temperatures[j]) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
            return result;
        }
    }
}
