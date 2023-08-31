package leetcode.array.hard.java_solutions;

public class MinimumReplacementsToSortTheArray_2366 {

    static class Solution {
        public long minimumReplacement(int[] nums) {
            var operations = 0L;
            var prevBound = nums[nums.length - 1];


            for (int i = nums.length - 2; i >= 0; i--) {
                var num = nums[i];
                var noOfTimes = (num + prevBound - 1) / prevBound;
                operations += noOfTimes - 1;
                prevBound = num / noOfTimes;
            }
            return operations;
        }
    }
}
