package leetcode.array.hard.java_solutions;

import java.util.HashMap;
import java.util.Map;

/*
Rust solution:

use std::collections::HashMap;

impl Solution {
    fn subarrays_with_k_distinct(nums: Vec<i32>, k: i32) -> i32 {
        Solution::sliding_window_at_most(&nums, k) - Solution::sliding_window_at_most(&nums, k - 1)
    }

    fn sliding_window_at_most(nums: &Vec<i32>, distinct_k: i32) -> i32 {
        let mut freq_map: HashMap<i32, i32> = HashMap::new();
        let (mut left, mut total_count) = (0, 0);

        for (right, &num) in nums.iter().enumerate() {
            *freq_map.entry(num).or_insert(0) += 1;

            while freq_map.len() > distinct_k as usize {
                if let Some(entry) = freq_map.get_mut(&nums[left]) {
                    *entry -= 1;
                    if *entry == 0 {
                        freq_map.remove(&nums[left]);
                    }
                }
                left += 1;
            }
            total_count += (right - left + 1) as i32;
        }
        total_count
    }
}
 */

public class SubarraysWithKDifferentIntegers_992 {

    static class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            return slidingWindowAtMost(nums, k) - slidingWindowAtMost(nums, k - 1);
        }

        private int slidingWindowAtMost(int[] nums, int distinctK) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            int left = 0, totalCount = 0;

            for (int right = 0; right < nums.length; right++) {
                freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

                while (freqMap.size() > distinctK) {
                    freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                    if (freqMap.get(nums[left]) == 0) {
                        freqMap.remove(nums[left]);
                    }
                    left++;
                }
                totalCount += (right - left + 1);
            }
            return totalCount;
        }
    }
}
