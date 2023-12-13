package golang_solutions

// pre-collect number of 1 per row and col

func numSpecial(mat [][]int) (result int) {
	rows := make([]int, len(mat))
	cols := make([]int, len(mat[0]))
	for i := 0; i < len(mat); i++ {
		for j, v := range mat[i] {
			if v == 1 {
				rows[i]++
				cols[j]++
			}
		}
	}
	for i := 0; i < len(mat); i++ {
		for j := range mat[i] {
			if mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1 {
				result++
			}
		}
	}
	return
}

// expand on every index

func numSpecialExpand(mat [][]int) (result int) {
	for i := 0; i < len(mat); i++ {
		for j, v := range mat[i] {
			if v == 1 && expand(mat, i, j) {
				result++
			}
		}
	}
	return
}

func expand(mat [][]int, row, col int) bool {
	for i := col - 1; i >= 0; i-- {
		if mat[row][i] == 1 {
			return false
		}
	}
	for i := col + 1; i < len(mat[row]); i++ {
		if mat[row][i] == 1 {
			return false
		}
	}
	for i := row - 1; i >= 0; i-- {
		if mat[i][col] == 1 {
			return false
		}
	}
	for i := row + 1; i < len(mat); i++ {
		if mat[i][col] == 1 {
			return false
		}
	}
	return true
}
