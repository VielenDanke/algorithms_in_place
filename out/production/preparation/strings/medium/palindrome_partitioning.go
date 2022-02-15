package medium

func Partition(s string) [][]string {
	result := make([][]string, 0)
	for k := 0; k < len(s); k++ {
		partitionPalindromeMemo(&result, []rune(s), make([]string, 0), 0, k)
	}
	return result
}

func partitionPalindromeMemo(result *[][]string, s []rune, temp []string, start int, k int) {
	if start == len(temp) {
		copyArr := make([]string, len(temp))
		for _, v := range temp {
			if isPalindrome(v) {
				copyArr = append(copyArr, v)
			}
		}
		*result = append(*result, copyArr)
		return
	} else {
		for i := start; i < len(s); i++ {
			temp = append(temp, string(s[i:i+k]))
			partitionPalindromeMemo(result, s[i+k:], temp, i+k+1, k)
			temp = temp[:len(temp)-1]
		}
	}
}

func partitionMemo(s string, memo map[string][][]string) [][]string {
	if val, ok := memo[s]; ok {
		return val
	}
	if len(s) == 0 {
		return [][]string{}
	}
	var result [][]string

	for i := 1; i <= len(s); i++ {
		if !isPalindrome(s[:i]) {
			continue
		}
		if i == len(s) {
			result = append(result, []string{s})
			continue
		}
		temp := partitionMemo(s[i:], memo)

		for _, t := range temp {
			n := append([]string{s[:i]}, t...)
			result = append(result, n)
		}
	}
	memo[s] = result
	return result
}

func isPalindrome(r string) bool {
	if len(r) == 0 {
		return true
	}
	start, end := 0, len(r)-1

	for start <= end {
		if r[start] != r[end] {
			return false
		}
		start++
		end--
	}
	return true
}
