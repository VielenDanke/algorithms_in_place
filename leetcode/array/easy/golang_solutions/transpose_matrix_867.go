package golang_solutions

func transpose(matrix [][]int) [][]int {
	cpMatrix := make([][]int, len(matrix[0]))
	for i := range cpMatrix {
		cpMatrix[i] = make([]int, len(matrix))
	}
	for i := range matrix {
		for j := range matrix[i] {
			cpMatrix[j][i] = matrix[i][j]
		}
	}
	return cpMatrix
}
