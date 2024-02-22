from typing import List


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        trust_count = [0] * (n + 1)

        for pair in trust:
            trust_count[pair[0]] -= 1
            trust_count[pair[1]] += 1
        for i in range(1, n + 1):
            if trust_count[i] == n - 1:
                return i
        return -1
