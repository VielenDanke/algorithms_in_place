package leetcode.stack.medium;

import java.util.Stack;

public class AsteroidCollision_735 {

    private static class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();

            for (int asteroid : asteroids) {
                if (asteroid > 0) {
                    stack.add(asteroid);
                } else {
                    while (!stack.isEmpty() && stack.peek() > 0 && asteroid * -1 > stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.add(asteroid);
                    }
                    if (!stack.isEmpty() && stack.peek() + asteroid == 0) {
                        stack.pop();
                    }
                }
            }
            int size = stack.size();
            asteroids = new int[size];
            for (int i = size - 1; i >= 0; i--) {
                asteroids[i] = stack.pop();
            }
            return asteroids;
        }
    }
}
