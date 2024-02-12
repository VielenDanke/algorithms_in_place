from typing import List


class Solution:

    def majorityElement(self, nums: List[int]) -> int:
        majority, count = 0, 0

        for n in nums:
            if count == 0:
                majority = n
            count = count + (1 if n == majority else -1)
        return majority

    def majorityElementSortNoIteration(self, nums: List[int]) -> int:
        nums.sort()
        return nums[len(nums) // 2]

    def majorityElementSort(self, nums: List[int]) -> int:
        nums.sort()

        cnt, n, current_number = 1, len(nums), nums[0]

        for i in range(1, n):
            if nums[i] == current_number:
                cnt += 1
            else:
                if cnt >= n / 2:
                    return current_number
                current_number = nums[i]
                cnt = 1
        if cnt >= n / 2:
            return current_number
        return -1

    def majorityElementMap(self, nums: List[int]) -> int:
        m = {}
        n = len(nums)
        for num in nums:
            if num not in m:
                m[num] = 0
            m[num] += 1
            if m[num] >= n / 2:
                return num
        return -1
