package leetcode.array.medium.java_solutions;

public class NonDecreasingArray_665 {

    public boolean checkPossibility(int[] nums) {
        int counter = 0;
        for (int i = 1; i < nums.length && counter <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                counter++;
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return counter <= 1;
    }
}
