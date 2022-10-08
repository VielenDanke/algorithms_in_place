package golang_solutions

func IsPalindrome(str string) bool {
	// translate to an leetcode.array of rune
	strRunes := []rune(str)
	// if string is empty? if string is one letters?
	if len(strRunes) == 0 {
		return false
	}
	if len(strRunes) == 1 {
		return true
	}
	// define two pointers and moving from end and start at the same time
	start, end := 0, len(strRunes)-1
	for start < end {
		if strRunes[start] != strRunes[end] {
			return false
		} else {
			start++
			end--
		}
	}
	return true
}

func IsPalindrome2(str string) bool {
	// translate to runes
	// check if length is 0 or 1
	// create stack and add untill we would reached middle of string
	// and after we pop from the stack and match the end letters
	runes := []rune(str)

	if len(runes) == 0 {
		return false
	}
	if len(runes) == 1 {
		return true
	}
	stack := make([]rune, 0)
	for idx, v := range runes {
		if idx < len(runes)/2 {
			stack = append(stack, v)
		} else if idx == len(runes)/2 && len(runes)%2 != 0 {
			continue
		} else {
			elem := stack[len(stack)-1]
			if elem != v {
				return false
			}
			stack = stack[:len(stack)-1]
		}
	}
	return true
}
