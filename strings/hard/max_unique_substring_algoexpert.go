package hard

func LongestSubstringWithoutDuplication(str string) (result string) {
	start, end := 0, 1

	for end < len(str) {
		storage := make(map[byte]int)
		storage[str[start]] = start
		for end < len(str) {
			if idx, ok := storage[str[end]]; ok {
				if len(result) < end-start {
					result = str[start:end]
				}
				start = idx + 1
				end = start + 1
				break
			}
			storage[str[end]] = end
			end++
		}
	}
	if len(result) < end-start {
		result = str[start:end]
	}
	return
}

func LongestSubstringWithoutDuplicationFullIteration(str string) (result string) {
	// Write your code here.
	start := 1
	left, right := 0, start

	for right <= len(str) {
		sub := str[left:right]
		if isUnique(sub) && len(result) < len(sub) {
			result = sub
		}
		left++
		right++
		if right > len(str) {
			left = 0
			right = start + 1
			start++
		}
	}
	return
}

func isUnique(str string) bool {
	storage := make(map[rune]interface{})
	for _, v := range str {
		if _, ok := storage[v]; ok {
			return false
		}
		storage[v] = nil
	}
	return true
}
