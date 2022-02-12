package easy

var brackets = make(map[rune]rune)

func init() {
	brackets['{'] = '}'
	brackets['('] = ')'
	brackets['['] = ']'
}

func ValidBrackets(s string) bool {
	stack := make([]rune, 0)

	for _, char := range s {
		if _, ok := brackets[char]; ok {
			stack = append(stack, char)
		} else {
			if len(stack) == 0 {
				return false
			}
			popCh := stack[len(stack)-1]
			if brackets[popCh] != char {
				return false
			}
			stack = stack[:len(stack)-1]
		}
	}
	return len(stack) == 0
}
