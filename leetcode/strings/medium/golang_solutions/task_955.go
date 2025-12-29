package golang_solutions

func minDeletionSize(strs []string) int {
	if len(strs) == 0 {
		return 0
	}

	n := len(strs)
	l := len(strs[0])

	sorted := make([]bool, n-1)
	deletions := 0

	for j := 0; j < l; j++ {
		keepColumn := true

		for i := 0; i < n-1; i++ {
			if !sorted[i] {
				if strs[i][j] > strs[i+1][j] {
					keepColumn = false
					break
				}
			}
		}

		if keepColumn {
			for i := 0; i < n-1; i++ {
				if !sorted[i] && strs[i][j] < strs[i+1][j] {
					sorted[i] = true
				}
			}
		} else {
			deletions++
		}
	}

	return deletions
}
