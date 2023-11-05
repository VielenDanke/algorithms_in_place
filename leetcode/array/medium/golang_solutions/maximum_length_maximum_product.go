package golang_solutions

import "math"

func GetMaxLen(nums []int) int {
	if len(nums) == 1 {
		if nums[0] > 0 {
			return 1
		}
		return 0
	}
	maxLength := 0
	for i := 0; i < len(nums); i++ {
		temp := 1
		length := 0
		for j := i; j < len(nums); j++ {
			temp *= nums[j]
			length++
			if temp > 0 && maxLength < length {
				maxLength = length
			}
		}
		if temp > 0 && maxLength < length {
			maxLength = length
		}
	}
	return maxLength
}

func getMaxLen(nums []int) int {
	if len(nums) == 1 {
		if nums[0] > 0 {
			return 1
		}
		return 0
	}
	maxLength, length, lenNeg, lastNegIdx := 0, 0, 0, -1
	isNegative := false
	for i := 0; i < len(nums); i++ {
		lenNeg++

		if nums[i] > 0 {
			length++
		} else if nums[i] < 0 {
			if lastNegIdx < 0 {
				lastNegIdx = i
			}
			if isNegative {
				isNegative = false
				length = lenNeg
			} else {
				isNegative = true
				length = i - lastNegIdx
			}
		} else {
			length, lenNeg, lastNegIdx = 0, 0, -1
			isNegative = false
		}
		maxLength = int(math.Max(float64(maxLength), float64(length)))
	}
	return maxLength
}
