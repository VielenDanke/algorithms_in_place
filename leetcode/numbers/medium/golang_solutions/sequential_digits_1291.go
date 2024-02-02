package golang_solutions

import (
	"sort"
	"strconv"
)

func sequentialDigits(low int, high int) []int {
	result := make([]int, 0)

	for i := 1; i <= 9; i++ {
		num := i

		for j := i + 1; j <= 9; j++ {
			num = num*10 + j

			if num >= low && num <= high {
				result = append(result, num)
			}
		}
	}
	sort.Ints(result)
	return result
}

// --------------------------------------------------------------------------------------------------------

func sequentialDigitsPreCalculatedString(low int, high int) []int {
	result := make([]int, 0)

	str := "123456789"

	for i := 0; i < len(str); i++ {
		for j := i + 1; j < len(str); j++ {
			num, _ := strconv.Atoi(str[i : j+1])
			if num >= low && num <= high {
				result = append(result, num)
			}
		}
	}
	sort.Ints(result)
	return result
}

// --------------------------------------------------------------------------------

func sequentialDigitsBruteForce(low int, high int) []int {
	result := make([]int, 0)
	for i := low; i <= high; i++ {
		if isValid(i) {
			result = append(result, i)
		}
	}
	return result
}

func isValid(num int) bool {
	lastNum := num%10 + 1

	for num > 0 {
		if lastNum-num%10 != 1 {
			return false
		}
		lastNum = num % 10
		num /= 10
	}
	return true
}
