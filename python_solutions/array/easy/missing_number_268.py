from typing import List


class Solution:

    def missingNumberIterative(self, nums: List[int]) -> int:
        num_sum = len(nums)
        for i in range(0, len(nums)):
            num_sum += i - nums[i]
        return num_sum

    def missingNumberBruteForce(self, nums: List[int]) -> int:
        nums.sort()

        start = min(nums)
        cp_start = start

        for num in nums:
            if num != start:
                return start
            start += 1
        return start if cp_start == 0 else cp_start - 1
