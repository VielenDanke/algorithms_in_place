package medium

var k int
var result [][]int

func subsets(nums []int, m map[int][]int) [][]int {
	for k = 1; k < len(nums)+1; k++ {
		recursiveResult(make([]int, 0), m, nums, 0)
	}
	return result
}

func recursiveResult(temp []int, m map[int][]int, nums []int, start int) {
	if val, ok := m[start]; ok {
		result = append(result, val)
	}
	if len(temp) == k {
		tempRes := make([]int, 0)
		for _, v := range temp {
			tempRes = append(tempRes, v)
		}
		m[start] = tempRes
		result = append(result, tempRes)
		return
	}
	for i := start; i < len(nums); i++ {
		temp = append(temp, nums[i])
		recursiveResult(temp, m, nums, i+1)
		temp = temp[:len(temp)-1]
	}
}

func Subsets(nums []int) [][]int {
	return subsets(nums, make(map[int][]int))
	//return helper(nums, 0, make(map[int][][]int))
}

func helper(nums []int, start int, memo map[int][][]int) [][]int {
	if val, ok := memo[start]; ok {
		return val
	}
	var result [][]int
	result = append(result, []int{})
	if start == len(nums) {
		return result
	}
	for i := start; i < len(nums); i++ {
		temp := helper(nums, i+1, memo)
		for j := range temp {
			t := append([]int{nums[i]}, temp[j]...)
			result = append(result, t)
		}
	}
	memo[start] = result
	return result
}
