package main

func bestSum(target int, numbers []int, memo map[int][]int) []int {
	if val, ok := memo[target]; ok {
		return val
	} else if target == 0 {
		return []int{}
	} else if target < 0 {
		return nil
	}
	var shortestCombination []int

	for _, v := range numbers {
		remainder := target - v
		remainderComb := bestSum(remainder, numbers, memo)
		if remainderComb != nil {
			remainderComb = append(remainderComb, v)
			if shortestCombination == nil || len(remainderComb) < len(shortestCombination) {
				shortestCombination = remainderComb
			}
		}
	}
	memo[target] = shortestCombination
	return shortestCombination
}
