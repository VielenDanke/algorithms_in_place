package main

import "sort"

func main() {
	organizingContainers([][]int32{{0, 2, 1}, {1, 1, 1}, {2, 0, 0}})
}

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
