package golang_solutions

func subsets(nums []int, m map[int][]int) [][]int {
	result := make([][]int, 0)
	for k := 1; k < len(nums)+1; k++ {
		recursiveResult(&result, make([]int, 0), m, nums, 0, k)
	}
	return result
}

func recursiveResult(result *[][]int, temp []int, m map[int][]int, nums []int, start, k int) {
	if len(temp) == k {
		*result = append(*result, append(make([]int, 0), temp...))
		return
	}
	for i := start; i < len(nums); i++ {
		temp = append(temp, nums[i])
		recursiveResult(result, temp, m, nums, i+1, k)
		temp = temp[:len(temp)-1]
	}
}

func Subsets(nums []int) [][]int {
	return subsets(nums, make(map[int][]int))
	//return helper(nums, 0, make(map[int][][]int))
}

func Powerset(array []int) [][]int {
	subsets := append(make([][]int, 0), []int{})
	for _, v := range array {
		length := len(subsets)
		for i := 0; i < length; i++ {
			newSubset := append([]int{}, subsets[i]...)
			newSubset = append(newSubset, v)
			subsets = append(subsets, newSubset)
		}
	}
	return subsets
}

func helper(nums []int, p int, memo map[int][][]int) [][]int {
	var result [][]int
	result = append(result, []int{})
	if len(nums) == p {
		return result
	}
	for i := p; i < len(nums); i++ {
		temp := helper(nums, i+1, memo)
		for j := range temp {
			t := append([]int{nums[i]}, temp[j]...)
			result = append(result, t)
		}
	}
	return result
}
