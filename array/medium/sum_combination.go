package medium

func CombinationSum(candidates []int, target int) [][]int {
	result := make([][]int, 0)
	helperCombinationSum(&result, candidates, make([]int, 0), target)
	return result
}

func helperCombinationSum(result *[][]int, candidates []int, temp []int, target int) {
	if target < 0 {
		return
	}
	if target == 0 {
		*result = append(*result, append(make([]int, 0), temp...))
		return
	}
	for i := range candidates {
		reminder := target - candidates[i]
		temp = append(temp, candidates[i])
		helperCombinationSum(result, candidates[i:], temp, reminder)
		temp = temp[:len(temp)-1]
	}
}

// ----------------------------------------------------------------------------------------------------

func CombinationSum2(candidates []int, target int) [][]int {
	result := make([][]int, 0)
	for i := range candidates {
		result = append(result, helperSumCombinationRecursive(candidates[i:], target))
	}
	return result
}

func helperSumCombinationRecursive(candidates []int, target int) []int {
	if target == 0 {
		return []int{}
	}
	if target < 0 {
		return nil
	}
	for i := range candidates {
		remainder := target - candidates[i]
		remainderResult := helperSumCombinationRecursive(candidates, remainder)
		if remainderResult != nil {
			remainderResult = append(remainderResult, candidates[i])
			return remainderResult
		}
	}
	return nil
}
