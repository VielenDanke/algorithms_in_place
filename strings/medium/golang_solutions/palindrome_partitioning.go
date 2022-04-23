package golang_solutions

func Partition(s string) [][]string {
	return partitionMemo(s, make(map[string][][]string))
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
