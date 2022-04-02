package hard

func FourNumberSum(array []int, target int) [][]int {
	return nil
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
