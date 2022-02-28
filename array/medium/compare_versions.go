package medium

import (
	"strconv"
	"strings"
)

func compareVersion(version1 string, version2 string) int {
	v1 := strings.Split(version1, ".")
	v2 := strings.Split(version2, ".")

	currIdx := 0

	for currIdx < len(v1) && currIdx < len(v2) {
		version := compareVersionPart(v1[currIdx], v2[currIdx])
		if version != 0 {
			return version
		}
		currIdx++
	}
	for currIdx < len(v1) {
		if removeTrailZeroIfExistsAndConvert(v1[currIdx]) > 0 {
			return 1
		}
		currIdx++
	}
	for currIdx < len(v2) {
		if removeTrailZeroIfExistsAndConvert(v2[currIdx]) > 0 {
			return -1
		}
		currIdx++
	}
	return 0
}

func removeTrailZeroIfExistsAndConvert(version string) int {
	if len(version) > 1 {
		return convertToInt(strings.TrimLeft(version, "0"))
	}
	return convertToInt(version)
}

func convertToInt(version string) int {
	v, _ := strconv.Atoi(version)
	return v
}

func compareVersionPart(v1, v2 string) int {
	v1WithoutZero := removeTrailZeroIfExistsAndConvert(v1)
	v2WithoutZero := removeTrailZeroIfExistsAndConvert(v2)

	if v1WithoutZero == v2WithoutZero {
		return 0
	} else if v1WithoutZero > v2WithoutZero {
		return 1
	} else {
		return -1
	}
}

func deleteAndEarn(nums []int) (max int) {
	for i := 0; i < len(nums); i++ {
		tempMax := deleteAll(append(make([]int, 0), nums...), i)
		if max < tempMax {
			max = tempMax
		}
	}
	return
}

func deleteAll(nums []int, idx int) int {
	if idx >= len(nums) || len(nums) == 0 {
		return 0
	}
	val := nums[idx]

	for i := idx; i < len(nums); i++ {
		if nums[i] == val-1 {
			nums = append(nums[:i], nums[i+1:]...)
		}
		if nums[i] == val+1 {
			nums = append(nums[:i], nums[i+1:]...)
		}
	}
	val += deleteAll(nums, idx+1)
	return val
}
