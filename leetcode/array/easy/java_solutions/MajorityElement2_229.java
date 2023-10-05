package leetcode.array.easy.java_solutions;

import java.util.*;

public class MajorityElement2_229 {

    static class Solution {
        /*
        Explanation: thanks to https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm#Correctness
        we know that we may have at maximum 2 elements with majority n / 3
         */
        public List<Integer> majorityElement(int[] nums) {
            int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0, majority = nums.length / 3;

            for (int num : nums) {
                if (candidate1 == num) {
                    count1++;
                } else if (candidate2 == num) {
                    count2++;
                } else if (count1 == 0) {
                    candidate1 = num;
                    count1 = 1;
                } else if (count2 == 0) {
                    candidate2 = num;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
            count1 = count2 = 0;

            for (int num : nums) {
                if (num == candidate1) {
                    count1++;
                } else if (num == candidate2) {
                    count2++;
                }
            }
            List<Integer> result = new ArrayList<>();
            if (count1 > majority) {
                result.add(candidate1);
            }
            if (count2 > majority) {
                result.add(candidate2);
            }
            return result;
        }
    }

    static class SolutionMap {
        public List<Integer> majorityElement(int[] nums) {
            int majority = nums.length / 3;
            Map<Integer, Integer> counterMap = new HashMap<>();
            List<Integer> result = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();

            for (int num : nums) {
                if (counterMap.merge(num, 1, Integer::sum) > majority && visited.add(num)) {
                    result.add(num);
                }
            }
            return result;
        }
    }

    static class SolutionMapTwoIterations {
        public List<Integer> majorityElement(int[] nums) {
            int majority = nums.length / 3;
            Map<Integer, Integer> counterMap = new HashMap<>();
            List<Integer> result = new ArrayList<>();

            for (int num : nums) {
                counterMap.merge(num, 1, Integer::sum);
            }
            for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
                if (entry.getValue() > majority) {
                    result.add(entry.getKey());
                }
            }
            return result;
        }
    }
}
