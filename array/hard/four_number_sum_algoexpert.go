package hard

// Average: O(N^2) time | O(N^2) space
// Worst: O(N^3) time | O(N^2) space

func FourNumberSum(array []int, target int) [][]int {
	allPairs := make(map[int][][]int)
	result := make([][]int, 0)
	for i := 0; i < len(array)-1; i++ {
		for j := i + 1; j < len(array); j++ {
			first := array[i]
			second := array[j]
			currentSum := first + second
			difference := target - currentSum
			if pairs, ok := allPairs[difference]; ok {
				for _, pair := range pairs {
					pair = append(pair, first, second)
					result = append(result, pair)
				}
			}
		}
		for k := 0; k < i; k++ {
			currentSum := array[i] + array[k]
			allPairs[currentSum] = append(allPairs[currentSum], []int{array[k], array[i]})
		}
	}
	return result
}

func FourNumberSumBruteForce(array []int, target int) [][]int {
	result := make([][]int, 0)
	for i := 0; i < len(array); i++ {
		for j := i + 1; j < len(array); j++ {
			for k := j + 1; k < len(array); k++ {
				for p := k + 1; p < len(array); p++ {
					if array[i]+array[j]+array[k]+array[p] == target {
						result = append(result, []int{array[i], array[j], array[k], array[p]})
					}
				}
			}
		}
	}
	return result
}
