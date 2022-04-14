package recursion_backtracking

func letterCasePermutation(s string) []string {
	result := make([]string, 0)
	backtrackLetterCasePermutation(&result, []rune(s), 0)
	return result
}

func backtrackLetterCasePermutation(result *[]string, s []rune, start int) {
	*result = append(*result, string(s))
	for i := start; i < len(s); i++ {
		isLowerCase := s[i] >= 'a' && s[i] <= 'z'
		isUpperCase := s[i] >= 'A' && s[i] <= 'Z'
		if isLowerCase || isUpperCase {
			if isLowerCase {
				s[i] = s[i] - 32
			}
			if isUpperCase {
				s[i] = s[i] + 32
			}
			backtrackLetterCasePermutation(result, s, i+1)
			if isLowerCase {
				s[i] = s[i] + 32
			}
			if isUpperCase {
				s[i] = s[i] - 32
			}
		} else {
			continue
		}
	}
}
