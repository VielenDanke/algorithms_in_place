package array.easy.java_solutions;

public class RunningSumOf1DArray_1480 {

    public int[] runningSum(int[] nums) {
        int prevSum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += prevSum;
            prevSum = nums[i];
        }
        return nums;
    }
}
