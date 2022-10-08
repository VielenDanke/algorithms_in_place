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

func orangesRottingBFS(grid [][]int) (minutes int) {
	dir := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	rowLength, columnLength := len(grid), len(grid[0])
	points := make([][]int, 0)
	goodOranges := 0

	for i := range grid {
		for j := range grid[i] {
			if grid[i][j] == 2 {
				points = append(points, []int{i, j})
			} else if grid[i][j] == 1 {
				goodOranges++
			}
		}
	}

	for len(points) > 0 && goodOranges != 0 {
		currentLength := len(points)

		var currentPoint []int

		for i := 0; i < currentLength; i++ {
			currentPoint, points = points[0], points[1:]
			for _, v := range dir {
				row, column := currentPoint[0], currentPoint[1]
				nextRow, nextColumn := row+v[0], column+v[1]
				if nextRow < 0 || nextColumn < 0 || nextRow >= rowLength || nextColumn >= columnLength || grid[nextRow][nextColumn] != 1 {
					continue
				}
				goodOranges--
				grid[nextRow][nextColumn] = 2
				points = append(points, []int{nextRow, nextColumn})
			}
		}
		minutes++
	}
	if goodOranges == 0 {
		return minutes
	}
	return -1
}
