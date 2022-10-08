package golang_solutions

type Pair struct {
	row    int
	column int
}

func setZeroesWithPairs(matrix [][]int) {
	rootPairs := make([]*Pair, 0)

	for i := range matrix {
		for j := range matrix[i] {
			current := matrix[i][j]
			if current == 0 {
				rootPairs = append(rootPairs, &Pair{row: i, column: j})
			}
		}
	}
	var currentPair *Pair
	for len(rootPairs) > 0 {
		currentPair, rootPairs = rootPairs[0], rootPairs[1:]

		row, column := 0, currentPair.column
		for row < len(matrix) {
			matrix[row][column] = 0
			row++
		}
		row, column = currentPair.row, 0

		for column < len(matrix[0]) {
			matrix[row][column] = 0
			column++
		}
	}
}

// ------------------------------------------------------------------------------------

func setZeroes(matrix [][]int) {
	for i := range matrix {
		for j := range matrix[i] {
			current := matrix[i][j]
			if current == 0 {
				matrix[i][j] = 1 << 50
			}
		}
	}
	for i := range matrix {
		for j := range matrix[i] {
			current := matrix[i][j]
			if current == 1<<50 {
				row, column := 0, j
				for row < len(matrix) {
					if matrix[row][column] != 1<<50 {
						matrix[row][column] = 0
					}
					row++
				}
				row, column = i, 0

				for column < len(matrix[0]) {
					if matrix[row][column] != 1<<50 {
						matrix[row][column] = 0
					}
					column++
				}
				matrix[i][j] = 0
			}
		}
	}
}
