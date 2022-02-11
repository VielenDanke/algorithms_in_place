package main

// O(n^m) - without memo
// O(n*m^2) - with memo
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
