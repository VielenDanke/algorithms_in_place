package backtracking

import "sort"

func subsetsWithDup(nums []int) [][]int {
	sort.Ints(nums)
	result := make([][]int, 0)
	findSubsets(0, nums, make([]int, 0), &result)
	return result
}

func findSubsets(ind int, nums []int, ds []int, result *[][]int) {
	temp := make([]int, 0)
	for _, v := range ds {
		temp = append(temp, v)
	}
	*result = append(*result, temp)
	for i := ind; i < len(nums); i++ {
		if i != ind && nums[i] == nums[i-1] {
			continue
		}
		ds = append(ds, nums[i])
		findSubsets(i+1, nums, ds, result)
		ds = ds[:len(ds)-1]
	}
}
