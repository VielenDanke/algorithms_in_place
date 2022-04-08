package sliding_window

func lengthOfLongestSubstring(s string) (max int) {
	if len(s) == 0 || len(s) == 1 {
		return len(s)
	}
	// visited for checking if string has a repetition characters
	// left, right for sliding window
	repeatMap := make(map[byte]interface{})

	left, right := 0, 1

	repeatMap[s[left]] = nil

	for right < len(s) {
		if _, ok := repeatMap[s[right]]; ok {
			if max < len(repeatMap) {
				max = len(repeatMap)
			}
			delete(repeatMap, s[left])
			left++
		} else {
			repeatMap[s[right]] = nil
			right++
		}
	}
	if len(repeatMap) > max {
		max = len(repeatMap)
	}
	return
}
