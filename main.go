package main

import "fmt"

func NumberOfWaysToMakeChange(n int, denoms []int) int {
	// Write your code here.
	counter := 0
	howSum(n, denoms, &counter)
	return counter
}

func howSum(n int, denoms []int, counter *int) {
	if n == 0 {
		*counter += 1
		return
	}
	for idx, v := range denoms {
		remainder := n - v
		if remainder < 0 {
			continue
		}
		howSum(remainder, denoms[idx:], counter)
	}
}

func main() {
	fmt.Printf("%v", NumberOfWaysToMakeChange(6, []int{1, 5}))
}
