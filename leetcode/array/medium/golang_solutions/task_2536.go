package golang_solutions

func rangeAddQueries(n int, queries [][]int) [][]int {
	result := make([][]int, n)

	for i := range result {
		result[i] = make([]int, n)
	}

	for _, query := range queries {
		for i := query[0]; i <= query[2]; i++ {
			for j := query[1]; j <= query[3]; j++ {
				result[i][j]++
			}
		}
	}
	return result
}
