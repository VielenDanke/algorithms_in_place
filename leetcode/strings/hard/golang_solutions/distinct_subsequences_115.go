package golang_solutions

func NumDistinctDynamic(s string, t string) int {
	matrix := make([][]int, len(t)+1)

	for i := range matrix {
		matrix[i] = make([]int, len(s)+1)
	}
	for i := 0; i < len(s); i++ {
		matrix[0][i] = 1
	}
	for i := 0; i < len(t); i++ {
		for j := 0; j < len(s); j++ {
			if t[i] == s[j] {
				matrix[i+1][j+1] = matrix[i][j] + matrix[i+1][j]
			} else {
				matrix[i+1][j+1] = matrix[i+1][j]
			}
		}
	}
	return matrix[len(t)][len(s)]
}

func NumDistinct(s string, t string) (num int) {
	backtrack(&num, []rune(s), make([]rune, 0), []rune(t), 0)
	return
}

func backtrack(num *int, root []rune, temp []rune, current []rune, startIdx int) {
	if len(temp) == len(current) {
		*num++
		return
	}
	for i := startIdx; i < len(root); i++ {
		temp = append(temp, root[i])
		if !equals(temp, current[:len(temp)]) {
			temp = temp[:len(temp)-1]
			continue
		}
		backtrack(num, root, temp, current, i+1)
		temp = temp[:len(temp)-1]
	}
}

func equals(first, second []rune) bool {
	if len(first) != len(second) {
		return false
	}
	for i := range first {
		if first[i] != second[i] {
			return false
		}
	}
	return true
}
