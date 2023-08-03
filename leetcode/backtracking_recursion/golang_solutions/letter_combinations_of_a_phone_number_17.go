package golang_solutions

var telephoneMap = map[byte][]rune{
	2: {'a', 'b', 'c'},
	3: {'d', 'e', 'f'},
	4: {'g', 'h', 'i'},
	5: {'j', 'k', 'l'},
	6: {'m', 'n', 'o'},
	7: {'p', 'q', 'r', 's'},
	8: {'t', 'u', 'v'},
	9: {'w', 'x', 'y', 'z'},
}

func letterCombinations(digits string) []string {
	combinations := make([]string, 0)
	if len(digits) == 0 {
		return combinations
	}
	backtrackPhoneNumber(&combinations, make([]rune, 0), digits, 0)

	return combinations
}

func backtrackPhoneNumber(combinations *[]string, temp []rune, digits string, idx int) {
	if idx >= len(digits) {
		*combinations = append(*combinations, string(temp))
		return
	}
	nextLetters := telephoneMap[digits[idx]-'0']
	for _, v := range nextLetters {
		temp = append(temp, v)
		backtrackPhoneNumber(combinations, temp, digits, idx+1)
		temp = temp[:len(temp)-1]
	}
}
