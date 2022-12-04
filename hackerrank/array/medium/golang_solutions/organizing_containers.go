package golang_solutions

import "sort"

// https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem

func organizingContainers(container [][]int32) string {
	n := len(container)
	balls := make([]int, n, n)

	for idx := range container {
		sum := 0
		for _, val := range container[idx] {
			sum += int(val)
		}
		balls[idx] = sum
	}

	types := make([]int, n, n)

	for idx := range container {
		sum := 0
		for _, v := range container {
			sum += int(v[idx])
		}
		types[idx] = sum
	}
	sort.Ints(balls)
	sort.Ints(types)
	for idx := range balls {
		if balls[idx] != types[idx] {
			return "Impossible"
		}
	}
	return "Possible"
}

func organizingContainersSet(container [][]int32) string {
	balls := make(map[int]interface{})

	for idx := range container {
		sum := 0
		for _, val := range container[idx] {
			sum += int(val)
		}
		balls[sum] = nil
	}

	types := make(map[int]interface{})

	for idx := range container {
		sum := 0
		for _, v := range container {
			sum += int(v[idx])
		}
		types[sum] = nil
	}
	for k := range balls {
		if _, ok := types[k]; !ok {
			return "Impossible"
		}
	}
	return "Possible"
}
