package golang_solutions

// my solution - https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/solutions/4337691/go-easy-to-understand-math-instead-of-dp/

const mod = 10e8 + 7

func numberOfWays(corridor string) int {
	chairs, plants, result := 0, 0, 1

	for _, place := range corridor {
		if place == 'S' {
			if chairs == 2 {
				result = (result * (plants + 1)) % mod
				chairs, plants = 0, 0
			}
			chairs++
		} else if chairs == 2 {
			plants++
		}
	}
	if chairs == 2 {
		return result
	}
	return 0
}
