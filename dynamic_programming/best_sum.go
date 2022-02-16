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

func betSumTabulation(target int, numbers []int) []int {
	var tab [][]int
	for i := 0; i < target+1; i++ {
		tab = append(tab, nil)
	}
	tab[0] = []int{}
	for i := 0; i < len(tab); i++ {
		if tab[i] != nil {
			for _, v := range numbers {
				if i+v < len(tab) {
					tab[i+v] = append(tab[i], v)
				}
			}
		}
	}
	return tab[target]
}
