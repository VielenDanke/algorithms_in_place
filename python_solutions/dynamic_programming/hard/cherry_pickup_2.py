from functools import cache
from typing import List


class Solution:

    def cherryPickup(self, grid: List[List[int]]) -> int:
        @cache
        def move(row: int, col_1: int, col_2: int) -> int:
            if row >= len(grid):
                return 0
            total = 0
            for m_1 in possible_moves:
                for m_2 in possible_moves:
                    next_col_1, next_col_2 = col_1 + m_1, col_2 + m_2
                    if next_col_1 >= len(grid[0]) or next_col_2 >= len(grid[0]) or next_col_1 < 0 or next_col_2 < 0:
                        continue
                    total = max(total, (move(row + 1, next_col_1, next_col_2) +
                                        (grid[row][col_1] if col_1 == col_2 else grid[row][col_1] + grid[row][col_2])))
            return total

        possible_moves = [-1, 0, 1]
        return move(0, 0, len(grid[0]) - 1)
