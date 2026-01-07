package golang_solutions

func sumFourDivisors(nums []int) int {
	result := 0
	cache := make(map[int]int)

	for _, num := range nums {
		if v, ok := cache[num]; ok {
			result += v
			continue
		}

		count := 0
		tempSum := 0

		for i := 1; i <= num; i++ {
			if num%i == 0 {
				count++
				tempSum += i

				if count > 4 {
					break
				}
			}
		}

		if count == 4 {
			result += tempSum
			cache[num] = tempSum
		} else {
			cache[num] = 0
		}
	}
	return result
}
