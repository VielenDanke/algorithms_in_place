from typing import List


class Solution:

    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort()
        _sum = sum(nums)
        for i in range(len(nums) - 1, 1, -1):
            _sum -= nums[i]
            if _sum > nums[i]:
                return _sum + nums[i]
        return -1

    def largestPerimeterPrefixSumSort(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return -1

        nums.sort()

        prefix_sum = [0] * len(nums)

        for i in range(len(nums)):
            prefix_sum[i] = nums[i] if i == 0 else nums[i] + prefix_sum[i - 1]

        for i in range(len(nums) - 1, 1, -1):
            if nums[i] < prefix_sum[i - 1]:
                return prefix_sum[i - 1] + nums[i]
        return -1
