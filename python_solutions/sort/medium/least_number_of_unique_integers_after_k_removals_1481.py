from collections import Counter
from typing import List


class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        count_sort = Counter(arr)
        sorted_values = sorted(count_sort.values())
        count = 0

        for value in sorted_values:
            if k < value:
                break
            k -= value
            count += 1
        return len(count_sort) - count

    def findLeastNumOfUniqueIntsShorter(self, arr: List[int], k: int) -> int:
        count_sort = Counter(arr)
        arr.sort(key=lambda x: (count_sort[x], x))
        arr = arr[k:]
        count_sort = Counter(arr)
        return len(count_sort)
