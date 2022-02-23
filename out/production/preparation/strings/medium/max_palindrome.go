package medium

func LongestPalindromicSubstring(str string) string {
	// Write your code here.
	runes := []rune(str)

	if isPalindrome(string(runes)) {
		return string(runes)
	}
	max := ""

	for i := 0; i < len(runes); i++ {
		for j := i; j <= len(runes); j++ {
			mbPal := runes[i:j]
			if isPalindrome(string(mbPal)) {
				if len(max) < len(mbPal) {
					max = string(mbPal)
				}
			}
		}
	}
	return max
}

// ########################################################

type substring struct {
	left  int
	right int
}

func (s substring) length() int {
	return s.right - s.left
}

func LongestPalindromicSubstring2(str string) string {
	// Write your code here.
	result := substring{0, 1}
	for i := 1; i < len(str); i++ {
		odd := getLongestPalindromeFrom(str, i-1, i+1)
		even := getLongestPalindromeFrom(str, i-1, i)
		longest := even
		if odd.length() > even.length() {
			longest = odd
		}
		if longest.length() > result.length() {
			result = longest
		}
	}
	return str[result.left:result.right]
}

func getLongestPalindromeFrom(str string, left, right int) substring {
	for left >= 0 && right < len(str) {
		if str[left] != str[right] {
			break
		}
		left--
		right++
	}
	return substring{left + 1, right}
}
