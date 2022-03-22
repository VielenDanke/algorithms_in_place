package medium

func GetSmallestStringOptimal(n, k int) string {
	result := make([]rune, n)

	for idx := range result {
		result[idx] = 'a'
	}
	k -= n
	for k > 0 {
		n = n - 1
		result[n] += rune(min(25, k))
		k -= min(25, k)
	}
	return string(result)
}

func min(f, s int) int {
	if f > s {
		return s
	}
	return f
}

func GetSmallestString(n int, k int) string {
	matrix := make([][]int, 0)

	for i := 0; i < n; i++ {
		current := 1
		matrix = append(matrix, make([]int, 0))
		for j := 0; j < 26; j++ {
			matrix[i] = append(matrix[i], current)
			current++
		}
	}
	return string(findMin(matrix, 0, k, n, make([]rune, 0)))
}

func findMin(matrix [][]int, row, k, n int, temp []rune) []rune {
	if row == n && k == 0 {
		return temp
	}
	if (row == n && k != 0) || row >= len(matrix) {
		return nil
	}
	for i := 0; i < 26; i++ {
		current := k - matrix[row][i]
		temp = append(temp, rune('a'+i))
		tempResult := findMin(matrix, row+1, current, n, temp)
		if tempResult != nil {
			return tempResult
		}
		temp = temp[:len(temp)-1]
	}
	return nil
}
