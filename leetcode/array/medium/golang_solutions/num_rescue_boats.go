package golang_solutions

import "sort"

func NumRescueBoats(people []int, limit int) (result int) {
	sort.Ints(people)
	left, right := 0, len(people)-1

	for left <= right {
		if people[right]+people[left] <= limit {
			left++
		}
		right--
		result++
	}
	return
}
