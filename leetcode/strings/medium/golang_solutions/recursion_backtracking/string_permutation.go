package recursion_backtracking

func StringPermutation(s string) []string {
	result := make([]string, 0)
	permuteString(&result, []rune(s), 0, len(s))
	return result
}

func permuteString(result *[]string, s []rune, left, right int) {
	if left == right {
		*result = append(*result, string(s))
		return
	}
	for i := left; i < len(s); i++ {
		s[left], s[i] = s[i], s[left]
		permuteString(result, s, left+1, right)
		s[left], s[i] = s[i], s[left]
	}
}

func StringPermutationSecond(s string) []string {
	result := make([]string, 0)
	visited := make([]bool, len(s))
	permuteStringSecond(&result, []rune(s), make([]rune, 0), visited)
	return result
}

func permuteStringSecond(result *[]string, s []rune, temp []rune, visited []bool) {
	if len(temp) == len(s) {
		*result = append(*result, string(temp))
		return
	}
	for i := 0; i < len(s); i++ {
		if visited[i] {
			continue
		}
		visited[i] = true
		temp = append(temp, s[i])
		permuteStringSecond(result, s, temp, visited)
		temp = temp[:len(temp)-1]
		visited[i] = false
	}
}
