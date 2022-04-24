package bfs_dfs

import "github.com/vielendanke/algorithms_in_place/array"

func orangesRotting(grid [][]int) (minutes int) {
	rottingOranges := make([]*array.Pair, 0)
	freshOranges := 0

	for i := range grid {
		for j := range grid[i] {
			if grid[i][j] == 2 {
				rottingOranges = append(rottingOranges, &array.Pair{Row: i, Col: j})
			} else if grid[i][j] == 1 {
				freshOranges++
			}
		}
	}
	for len(rottingOranges) > 0 {
		amountOfOranges := len(rottingOranges)

		for i := 0; i < amountOfOranges; i++ {
			pair := rottingOranges[i]

			if pair.Row-1 >= 0 && grid[pair.Row-1][pair.Col] == 1 {
				rottingOranges = append(rottingOranges, &array.Pair{Row: pair.Row - 1, Col: pair.Col})
				grid[pair.Row-1][pair.Col] = 2
				freshOranges--
			}
			if pair.Row+1 < len(grid) && grid[pair.Row+1][pair.Col] == 1 {
				rottingOranges = append(rottingOranges, &array.Pair{Row: pair.Row + 1, Col: pair.Col})
				grid[pair.Row+1][pair.Col] = 2
				freshOranges--
			}
			if pair.Col-1 >= 0 && grid[pair.Row][pair.Col-1] == 1 {
				rottingOranges = append(rottingOranges, &array.Pair{Row: pair.Row, Col: pair.Col - 1})
				grid[pair.Row][pair.Col-1] = 2
				freshOranges--
			}
			if pair.Col+1 < len(grid[0]) && grid[pair.Row][pair.Col+1] == 1 {
				rottingOranges = append(rottingOranges, &array.Pair{Row: pair.Row, Col: pair.Col + 1})
				grid[pair.Row][pair.Col+1] = 2
				freshOranges--
			}
		}
		rottingOranges = rottingOranges[amountOfOranges:]
		if len(rottingOranges) == 0 {
			break
		}
		minutes++
	}
	if freshOranges != 0 {
		return -1
	}
	return
}
