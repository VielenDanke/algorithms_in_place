package golang_solutions

import "sort"

// pick coins in the order [min, rightAfterMax, max], so when your turn it will be the next possible maximum

func maxCoins(piles []int) (result int) {
	sort.Ints(piles)

	left, right := 0, len(piles)-1

	for left < right {
		result += piles[right-1]
		right -= 2
		left++
	}
	return
}
