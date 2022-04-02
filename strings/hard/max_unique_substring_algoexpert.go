package hard

type substring struct {
	left  int
	right int
}

func (ss substring) length() int {
	return ss.right - ss.left
}

func LongestSubstringWithoutDuplication(str string) string {
	lastSeen := make(map[rune]int)
	longest := substring{0, 1}
	startIndex := 0
	for i, char := range str {
		if seenIndex, found := lastSeen[char]; found && startIndex < seenIndex+1 {
			startIndex = seenIndex + 1
		}
		if longest.length() < i+1-startIndex {
			longest = substring{startIndex, i + 1}
		}
		lastSeen[char] = i
	}
	return str[longest.left:longest.right]
}

func LongestSubstringWithoutDuplicationSecondApproach(str string) (result string) {
	start, end := 0, 1
	storage := make(map[byte]int)

	for end < len(str) {
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
