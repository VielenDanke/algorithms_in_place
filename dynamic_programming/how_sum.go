package main

import "fmt"

// O(n^m)
func howSum(target int, numbers []int, memo map[int][]int) []int {
	if _, ok := memo[target]; ok {
		return memo[target]
	}
	if target == 0 {
		return []int{}
	}
	if target < 0 {
		return nil
	}
	for _, num := range numbers {
		remainder := target - num
		remainderResult := howSum(remainder, numbers, memo)
		if remainderResult != nil {
			remainderResult = append(remainderResult, num)
			memo[target] = remainderResult
			return remainderResult
		}
	}
	memo[target] = nil
	return nil
}

func main() {
	fmt.Printf("Result: %v\n", howSum(300, []int{130, 170}, make(map[int][]int)))
}
