from typing import List


class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        result = [0] * len(nums)
        i_pos, i_neg = 0, 1
        for num in nums:
            if num > 0:
                i = i_pos
                i_pos += 2
            else:
                i = i_neg
                i_neg += 2
            result[i] = num
        return result

    def rearrangeArrayNoExtraArrays(self, nums: List[int]) -> List[int]:
        left, right = 0, 0
        result = []
        while left < len(nums) and right < len(nums):
            if left < len(nums):
                while nums[left] < 0:
                    left += 1
                result.append(nums[left])
            if right < len(nums):
                while nums[right] > 0:
                    right += 1
                result.append(nums[right])
            left += 1
            right += 1
        return result

    def rearrangeArrayDeclarative(self, nums: List[int]) -> List[int]:
        return [num for pair in zip([n for n in nums if n > 0], [n for n in nums if n <= 0]) for num in pair]

    def rearrangeArrayTwoArrays(self, nums: List[int]) -> List[int]:
        positive, negative, result = [], [], []

        for n in nums:
            if n > 0:
                positive.append(n)
            else:
                negative.append(n)
        for i in range(len(positive)):
            result.append(positive[i])
            result.append(negative[i])
        return result
