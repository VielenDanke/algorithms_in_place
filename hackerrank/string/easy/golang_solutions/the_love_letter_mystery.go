package golang_solutions

import "math"

func theLoveLetterMystery(s string) (op int32) {
	// Write your code here
	runes := []rune(s)
	left, right := 0, len(runes)-1

	for left < right {
		op += int32(math.Abs(float64(runes[left]-'a') - float64(runes[right]-'a')))
		left++
		right--
	}
	return op
}
