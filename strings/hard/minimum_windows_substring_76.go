package hard

func MinWindow(s string, t string) string {
	if len(s) < len(t) {
		return ""
	}
	storage := make(map[rune]int)

	for _, v := range t {
		storage[v]++
	}
	left, right, index, counter, minLen := 0, 0, 0, len(t), 1<<31

	for right < len(s) {
		rightRune := rune(s[right])
		if storage[rightRune] > 0 {
			counter--
		}
		storage[rightRune]--
		right++
		for counter == 0 {
			if right-left < minLen {
				minLen = right - left
				index = left
			}
			leftRune := rune(s[left])
			storage[leftRune]++
			if storage[leftRune] == 1 {
				counter++
			}
			left++
		}
	}
	if minLen == 1<<31 {
		return ""
	}
	return s[index : index+minLen]
}

func MinWindowTimeLimitExceeded(s string, t string) string {
	if len(t) > len(s) {
		return ""
	}
	window := len(t)

	for window <= len(s) {
		for i := 0; i+window <= len(s); i++ {
			if isContains(s, s[i:i+window]) {
				return s[i : i+window]
			}
		}
		window++
	}
	return ""
}

func isContains(s string, t string) bool {
	m := make(map[rune]int)

	for _, v := range t {
		m[v]++
	}
	for _, v := range s {
		m[v]--
	}
	for _, v := range m {
		if v > 0 {
			return false
		}
	}
	return true
}
