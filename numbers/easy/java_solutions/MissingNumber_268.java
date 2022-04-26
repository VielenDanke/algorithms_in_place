package numbers.easy.java_solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MissingNumber_268 {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        return length * (length + 1) / 2 - IntStream.of(nums).sum();
    }

    public int missingNumberBest(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += i - nums[i];
        }
        return sum;
    }

    public int missingNumberSort(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                return i + 1;
            }
        }
        if (nums[0] > 0) {
            return nums[0] - 1;
        }
        return nums[nums.length - 1] + 1;
    }

    public int missingNumberUsingSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 1 << 30;
        int max = -1 << 30;

        for (int val : nums) {
            set.add(val);
            if (min > val) {
                min = val;
            }
            if (max < val) {
                max = val;
            }
        }
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        if (min > 0) {
            return min - 1;
        }
        return max + 1;
    }
}
