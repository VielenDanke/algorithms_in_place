package sliding_window

func countSubstrings(s string) (sum int) {
	if len(s) == 0 {
		return
	}
	sum += len(s)

	windowSize := 2

	for windowSize <= len(s) {
		for i := 0; i+windowSize <= len(s); i++ {
			if isPalindromic(s[i : i+windowSize]) {
				sum++
			}
		}
		windowSize++
	}
	return
}

func countSubstringsBetter(s string) (sum int) {
	if len(s) == 0 {
		return 0
	}
	for i := 0; i < len(s); i++ {
		extendPalindrome(s, i, i, &sum)
		extendPalindrome(s, i, i+1, &sum)
	}
	return sum
}

func extendPalindrome(str string, left int, right int, sum *int) {
	for left >= 0 && right < len(str) && str[left] == str[right] {
		*sum++
		left--
		right++
	}
}

func isPalindromic(str string) bool {
	left, right := 0, len(str)-1

	for left <= right {
		if str[left] != str[right] {
			return false
		}
		left++
		right--
	}
	return true
}
