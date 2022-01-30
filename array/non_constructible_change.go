package array

import "sort"

func NonConstructibleChange(coins []int) int {
	// Write your code here.
	// positive integers
	// not unique
	// no coins = 1
	sort.Ints(coins)

	currentChange := 0
	for _, coin := range coins {
		if coin > currentChange+1 {
			return currentChange + 1
		}
		currentChange += coin
	}
	return currentChange + 1
}
