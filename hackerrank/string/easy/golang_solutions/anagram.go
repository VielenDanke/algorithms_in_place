package golang_solutions

import "math"

func anagram(s string) int32 {
	// Write your code here
	n := len(s)

	if n%2 != 0 {
		return -1
	}
	runes := []rune(s)

	left, right := make([]int, 26, 26), make([]int, 26, 26)

	for i := 0; i < n/2; i++ {
		left[runes[i]-'a']++
	}
	for i := n / 2; i < n; i++ {
		right[runes[i]-'a']++
	}
	toChange := int32(0)

	for i := 0; i < 26; i++ {
		toChange += int32(math.Abs(float64(left[i]) - float64(right[i])))
	}
	return toChange / 2
}
