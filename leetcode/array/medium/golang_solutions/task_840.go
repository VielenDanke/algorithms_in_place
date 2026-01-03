package golang_solutions

func numMagicSquaresInside(grid [][]int) int {
	rows := len(grid)
	if rows < 3 {
		return 0
	}
	cols := len(grid[0])
	if cols < 3 {
		return 0
	}

	count := 0
	for r := 0; r <= rows-3; r++ {
		for c := 0; c <= cols-3; c++ {
			if isMagic(grid, r, c) {
				count++
			}
		}
	}
	return count
}

func isMagic(grid [][]int, r, c int) bool {
	if grid[r+1][c+1] != 5 {
		return false
	}

	seen := [10]bool{}
	for i := 0; i < 3; i++ {
		for j := 0; j < 3; j++ {
			val := grid[r+i][c+j]
			if val < 1 || val > 9 || seen[val] {
				return false
			}
			seen[val] = true
		}
	}

	if grid[r][c]+grid[r][c+1]+grid[r][c+2] != 15 {
		return false
	}
	if grid[r+2][c]+grid[r+2][c+1]+grid[r+2][c+2] != 15 {
		return false
	}

	if grid[r][c]+grid[r+1][c]+grid[r+2][c] != 15 {
		return false
	}
	if grid[r][c+1]+grid[r+1][c+1]+grid[r+2][c+1] != 15 {
		return false
	}
	if grid[r][c+2]+grid[r+1][c+2]+grid[r+2][c+2] != 15 {
		return false
	}

	if grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2] != 15 {
		return false
	}
	if grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c] != 15 {
		return false
	}

	return true
}
