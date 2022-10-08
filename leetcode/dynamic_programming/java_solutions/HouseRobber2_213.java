package leetcode.dynamic_programming.java_solutions;

public class HouseRobber2_213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int N = nums.length;

        int[] first = new int[N + 1];
        int[] second = new int[N + 1];

        first[0] = 0;
        first[1] = nums[0];
        second[0] = 0;
        second[1] = 0;

        for (int i = 2; i <= N; i++) {
            first[i] = Math.max(first[i - 1], first[i - 2] + nums[i - 1]);
            second[i] = Math.max(second[i - 1], second[i - 2] + nums[i - 1]);
        }
        return Math.max(first[N - 1], second[N]);
    }
}
