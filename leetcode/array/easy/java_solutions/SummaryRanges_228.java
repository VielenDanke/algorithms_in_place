package leetcode.array.easy.java_solutions;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges_228 {

    static class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> result = new LinkedList<>();

            if (nums == null || nums.length == 0) {
                return result;
            }
            int start = 0;

            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] - nums[i - 1] != 1) {
                    if (start == i - 1) {
                        result.add(String.format("%d", nums[start]));
                    } else {
                        result.add(String.format("%d->%d", nums[start], nums[i - 1]));
                    }
                    start = i;
                }
            }
            if (start == nums.length - 1) {
                result.add(String.format("%d", nums[start]));
            } else {
                result.add(String.format("%d->%d", nums[start], nums[nums.length - 1]));
            }
            return result;
        }
    }
}
