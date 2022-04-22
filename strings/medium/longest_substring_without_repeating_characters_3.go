package medium

// link - https://leetcode.com/problems/longest-substring-without-repeating-characters/

func lengthOfLongestSubstring(s string) (max int) {
	set := make(map[byte]interface{})

	left, right := 0, 0

	for right < len(s) {
		for right < len(s) {
			if _, ok := set[s[right]]; ok {
				break
			}
			set[s[right]] = nil
			right++

		}
		if len(set) > max {
			max = len(set)
		}
		for left <= right && right < len(s) {
			delete(set, s[left])
			left++
			if _, ok := set[s[right]]; !ok {
				break
			}
		}
	}
	return
}

func lengthOfLongestSubstringTwo(s string) (max int) {
	if len(s) == 0 {
		return 0
	}
	if len(s) == 1 {
		return 1
	}
	// visited for checking if string has a repetition characters
	// left, right for tracing window
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
