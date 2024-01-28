package hard

func numSubmatrixSumTarget(matrix [][]int, target int) int {
	m, n := len(matrix), len(matrix[0])
	result := 0

	for idx := 0; idx < n; idx++ {
		sums := make([]int, 105)
		for col := idx; col < n; col++ {
			for row := 0; row < m; row++ {
				sums[row] += matrix[row][col]
			}
			for i := 0; i < m; i++ {
				sum := 0
				for j := i; j < m; j++ {
					sum += sums[j]
					if sum == target {
						result++
					}
				}
			}
		}
	}
	return result
}
