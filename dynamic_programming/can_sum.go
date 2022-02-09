package main

import "fmt"

func canSumIterative(target int, numbers []int) bool {
	if len(numbers) == 2 {
		return target == numbers[0]+numbers[1]
	} else if len(numbers) == 1 {
		return numbers[0] == target
	} else if len(numbers) == 0 {
		return false
	}
	start, end, sum := 0, 1, 0
	sum = numbers[start] + numbers[end]

	for end < len(numbers)-1 {
		if sum > target {
			sum -= numbers[start]
			start++
		} else if sum < target {
			end++
			sum += numbers[end]
		} else {
			return true
		}
	}
	return false
}

func canSum(target int, numbers []int, memo map[int]bool) bool {
	if _, ok := memo[target]; ok {
		return memo[target]
	}
	if target == 0 {
		return true
	} else if target < 0 {
		return false
	}
	for _, num := range numbers {
		remainder := target - num
		if canSum(remainder, numbers, memo) {
			memo[target] = true
			return true
		}
	}
	memo[target] = false
	return false
}

func main() {
	fmt.Println(canSum(300, []int{7, 14}, make(map[int]bool)))
}
