from typing import List


class Solution:

    def missingNumberIterative(self, nums: List[int]) -> int:
        num_sum = len(nums)
        for i in range(0, len(nums)):
            num_sum += i - nums[i]
        return num_sum

    def missingNumberArithmetic(self, nums: List[int]) -> int:
        n = len(nums)
        total_sum = n * (n + 1) // 2
        array_sum = sum(nums)
        return total_sum - array_sum

    def missingNumberBruteForce(self, nums: List[int]) -> int:
        nums.sort()

        for i, num in enumerate(nums):
            if i != num:
                return i
        return len(nums)
