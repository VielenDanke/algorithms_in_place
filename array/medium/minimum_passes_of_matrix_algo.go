package medium

func MinimumPassesOfMatrix(matrix [][]int) (count int) {
	// count negative integers
	// for each negative turnover decrease negative count
	// return from recursive if negative integers == 0 (return current amount of iteration)
	converted := make([][]bool, len(matrix))
	negative := 0

	for i := range converted {
		converted[i] = make([]bool, len(matrix[i]))
		for j := range converted[i] {
			if matrix[i][j] >= 0 {
				converted[i][j] = true
			}
			if matrix[i][j] < 0 {
				negative++
			}
		}
	}
	for negative > 0 {
		if count > len(matrix)*len(matrix[0]) {
			return -1
		}
		for i := range matrix {
			for j := range matrix[i] {
				if matrix[i][j] > 0 {
					if i-1 >= 0 {
						if matrix[i-1][j] < 0 {
							converted[i-1][j] = true
						}
					}
					if i+1 < len(matrix) {
						if matrix[i+1][j] < 0 {
							converted[i+1][j] = true
						}
					}
					if j-1 >= 0 {
						if matrix[i][j-1] < 0 {
							converted[i][j-1] = true
						}
					}
					if j+1 < len(matrix[i]) {
						if matrix[i][j+1] < 0 {
							converted[i][j+1] = true
						}
					}
				}
			}
		}
		for i := range matrix {
			for j := range matrix[i] {
				if matrix[i][j] < 0 && converted[i][j] {
					matrix[i][j] *= -1
					negative--
				}
			}
		}
		count++
	}
	return count
}
