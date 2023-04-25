package golang_solutions

import (
	"fmt"
	"strconv"
)

func separateNumbers(s string) {
	// Write your code here
	result := backtrack(s, make([]int, 0))
	if result != 0 {
		fmt.Printf("YES %d\n", result)
	} else {
		fmt.Println("NO")
	}
}

func backtrack(s string, nums []int) int {
	if len(s) == 0 {
		if len(nums) > 1 {
			return nums[0]
		}
		return 0
	}
	for i := 0; i <= len(s); i++ {
		sub := s[:i]

		if len(sub) == 0 {
			continue
		}
		if sub[0] == '0' {
			break
		}
		nextInt, _ := strconv.Atoi(sub)

		if len(nums) == 0 || nums[len(nums)-1]+1 == nextInt {
			nums = append(nums, nextInt)
			result := backtrack(s[i:], nums)
			if result != 0 {
				return result
			}
			nums = nums[:len(nums)-1]
		} else if nums[len(nums)-1]+1 < nextInt {
			break
		}
	}
	return 0
}
