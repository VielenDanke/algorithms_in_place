package golang_solutions

import "sort"

func closeStrings(word1 string, word2 string) bool {
	if len(word1) != len(word2) {
		return false
	}
	count1, count2 := make([]int, 26), make([]int, 26)

	for idx := range word1 {
		count1[word1[idx]-'a']++
		count2[word2[idx]-'a']++
	}
	for i := 0; i < 26; i++ {
		if (count1[i] > 0 && count2[i] == 0) || (count1[i] == 0 && count2[i] > 0) {
			return false
		}
	}
	sort.Ints(count1)
	sort.Ints(count2)

	for i := 0; i < 26; i++ {
		if count1[i] != count2[i] {
			return false
		}
	}
	return true
}
