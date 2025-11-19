package golang_solutions

import "sort"

func findFinalValue(nums []int, original int) int {
	store := make(map[int]interface{})

	for _, num := range nums {
		store[num] = nil

		for {
			if _, ok := store[original]; ok {
				original *= 2
			} else {
				break
			}
		}
	}
	return original
}

func findFinalValueSort(nums []int, original int) int {
	sort.Ints(nums)

	for i := 0; i < len(nums); i++ {
		if nums[i] == original {
			original *= 2
		}
	}
	return original
}

func findFinalValueBruteForce(nums []int, original int) int {
	mustGoing := true

	for mustGoing {
		mustGoing = false
		for _, num := range nums {
			if num == original {
				original = original * 2
				mustGoing = true
			}
		}
	}
	return original
}
