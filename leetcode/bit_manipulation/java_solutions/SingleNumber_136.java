package leetcode.bit_manipulation.java_solutions;

public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        int count = 0;

        for (int i : nums) {
            count ^= i;
        }
        return count;
    }
}
