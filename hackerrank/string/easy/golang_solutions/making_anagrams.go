package golang_solutions

import "math"

func makingAnagrams(s1 string, s2 string) int32 {
	// Write your code here
	left, right := make([]int, 26, 26), make([]int, 26, 26)

	for _, v := range []rune(s1) {
		left[v-'a']++
	}
	for _, v := range []rune(s2) {
		right[v-'a']++
	}
	count := int32(0)

	for i := 0; i < 26; i++ {
		count += int32(math.Abs(float64(left[i]) - float64(right[i])))
	}
	return count
}
