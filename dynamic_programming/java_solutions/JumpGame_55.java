package dynamic_programming.java_solutions;

public class JumpGame_55 {

    /*
    Pattern: start from last and iterate in decreasing order
             try to add to current idx jump length
             if position is reachable - place lastPos to current idx

    Example: [2,3,1,1,4]

             1) idx 3 + 1 >= 4 - yes, set lastPos to 3
             2) idx 2 + 1 >= 3 - yes, set lastPos to 2
             3) idx 1 + 3 >= 2 - yes, set lastPos to 1
             4) idx 0 + 2 >= 1 - yes, set lastPos to 0
     */

    static class SolutionBest {
        public boolean canJump(int[] nums) {
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i + nums[i] >= lastPos) {
                    lastPos = i;
                }
            }
            return lastPos == 0;
        }
    }

    static class SolutionDP {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n];

            dp[0] = true;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && nums[j] + j >= i) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n - 1];
        }
    }
}
