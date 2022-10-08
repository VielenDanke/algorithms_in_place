package leetcode.array.medium.java_solutions;

import java.util.Stack;

public class Pattern132_456 {

    public boolean find132pattern(int[] nums) {
        int n = nums.length, top = n, third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) return true;
            while (top < n && nums[i] > nums[top]) third = nums[top++];
            nums[--top] = nums[i];
        }
        return false;
    }

    public boolean find132patternStack(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()[0]) {
                stack.pop();
            }
            if (!stack.isEmpty() && nums[i] < stack.peek()[0] && nums[i] > stack.peek()[1]) {
                return true;
            }
            stack.add(new int[]{nums[i], min});
            min = Math.min(nums[i], min);
        }
        return false;
    }
}
