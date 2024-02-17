import heapq
from typing import List


class Solution:

    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        hq = []
        last_idx = len(heights) - 1
        for i in range(last_idx):
            diff = heights[i + 1] - heights[i]
            if diff > 0:
                heapq.heappush(hq, diff)
            if len(hq) > ladders:
                bricks -= heapq.heappop(hq)
            if bricks < 0:
                return i
        return last_idx

    def furthestBuildingBruteForce(self, heights: List[int], bricks: int, ladders: int) -> int:
        def go_next(idx: int, bricks: int, ladders: int) -> int:
            if bricks < 0:
                return idx - 1
            elif ladders < 0:
                return idx - 1
            if idx == len(heights) - 1:
                return idx
            current_height, next_height = heights[idx], heights[idx + 1]
            if current_height > next_height:
                return go_next(idx + 1, bricks, ladders)
            else:
                return max(go_next(idx + 1, bricks - (next_height - current_height), ladders),
                           go_next(idx + 1, bricks, ladders - 1))

        return go_next(0, bricks, ladders)
