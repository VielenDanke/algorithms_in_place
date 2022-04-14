package dynamic_programming

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

func howSumTabulation(target int, numbers []int) []int {
	var tab [][]int
	for i := 0; i < target+1; i++ {
		tab = append(tab, nil)
	}
	tab[0] = []int{}
	for idx := range tab {
		if tab[idx] != nil {
			for _, v := range numbers {
				if idx+v >= len(tab) {
					break
				}
				if tab[idx+v] != nil {
					t := append(tab[idx], v)
					if len(tab[idx+v]) > len(t) {
						tab[idx+v] = t
					}
				} else {
					tab[idx+v] = append(tab[idx], v)
				}
			}
		}
	}
	return tab[target]
}
