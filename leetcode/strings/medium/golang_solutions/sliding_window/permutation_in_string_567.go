package sliding_window

func checkInclusionArrayCountRune(s1, s2 string) bool {
	if len(s1) > len(s2) {
		return false
	}
	// only lower letters are considered, 26 low letters in english alphabet
	s1RuneCount := make([]int, 26)
	s2RuneCount := make([]int, 26)

	// add to s1 and s2 start of leetcode.strings in amount of len(s1)
	for idx := range s1 {
		s1RuneCount[s1[idx]-'a']++
		s2RuneCount[s2[idx]-'a']++
	}
	// check if start already equals
	if arrayEqual(s1RuneCount, s2RuneCount) {
		return true
	}
	// iterate over, the key thing here is add new letter and remove previous letter in window
	// window = len(s1)
	// everytime check if arrays are equal
	for i := len(s1); i < len(s2); i++ {
		s2RuneCount[s2[i]-'a']++
		s2RuneCount[s2[i-len(s1)]-'a']--
		if arrayEqual(s1RuneCount, s2RuneCount) {
			return true
		}
	}
	return false
}

func arrayEqual(s1, s2 []int) bool {
	if len(s1) != len(s2) {
		return false
	}
	for idx := range s1 {
		if s1[idx] != s2[idx] {
			return false
		}
	}
	return true
}

// ----------------------------------------------

func checkInclusion(s1 string, s2 string) bool {
	window := len(s1)

	for i := 0; i <= len(s2)-window; i++ {
		if isPermutation(s1, s2[i:i+window]) {
			return true
		}
	}
	return false
}

func isPermutation(s1, s2 string) bool {
	permMap := make(map[rune]int)

	for _, v := range s1 {
		permMap[v]++
	}
	for _, v := range s2 {
		permMap[v]--
		if permMap[v] < 0 {
			return false
		}
	}
	for _, v := range permMap {
		if v != 0 {
			return false
		}
	}
	return true
}
