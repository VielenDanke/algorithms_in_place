package easy

func validPalindrome(s string) bool {
	left, right := 0, len(s)-1

	for left < right {
		if s[left] != s[right] {
			return isPalindrome(s, left, right-1) || isPalindrome(s, left+1, right)
		}
		left++
		right--
	}
	return true
}

func isPalindrome(str string, left, right int) bool {
	for left < right {
		if str[left] != str[right] {
			return false
		}
		left++
		right--
	}
	return true
}
