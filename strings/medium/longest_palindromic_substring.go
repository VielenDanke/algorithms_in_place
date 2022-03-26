package medium

func LongestPalindrome(s string) (answer string) {
	windowLength := 2

	if len(s) == 0 {
		return
	}
	if len(s) == 1 {
		answer = string(s[0])
		return
	}
	if len(s) == 2 {
		if isPalindromeSub(s) {
			return s
		}
		return string(s[0])
	}
	for windowLength <= len(s) {
		for i := 0; i <= len(s)-windowLength; i++ {
			if isPalindromeSub(s[i : i+windowLength]) {
				answer = s[i : i+windowLength]
				break
			}
		}
		windowLength++
	}
	if len(answer) == 0 {
		answer = string(s[0])
	}
	return
}

func isPalindromeSub(s string) bool {
	if len(s) == 0 || len(s) == 1 {
		return true
	}
	left, right := 0, len(s)-1

	for left < right {
		if s[left] != s[right] {
			return false
		}
		left++
		right--
	}
	return true
}
