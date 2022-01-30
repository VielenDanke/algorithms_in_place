package easy

import "sort"

/*
[1, 2, 2, 3, 6]
for 1 all queries should wait 1 sec
from the previous state - len(array) - 1 - i * wait time (array[i])
*/

func MinimumWaitingTime(queries []int) (sum int) {
	// is query empty or nil?
	if queries == nil || len(queries) == 0 {
		return -1
	}
	sort.Ints(queries)
	for i, duration := range queries {
		queriesLeft := len(queries) - 1 - i
		sum += duration * queriesLeft
	}
	return
}

func MinimumWaitingTime2(queries []int) (result int) {
	// is query empty or nil?
	if queries == nil || len(queries) == 0 {
		return -1
	}
	sort.Ints(queries)
	var sum int
	for i := 1; i < len(queries); i++ {
		sum += queries[i-1]
		queries[i-1] = sum
	}
	for i := 0; i < len(queries)-1; i++ {
		result += queries[i]
	}
	return
}
