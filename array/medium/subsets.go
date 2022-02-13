package medium

var k int
var result [][]int

func subsets(nums []int) [][]int {
	for k = 0; k < len(nums)+1; k++ {
		recursiveResult(make([]int, 0), make(map[int]interface{}), nums, 0)
	}
	return result
}

func recursiveResult(temp []int, m map[int]interface{}, nums []int, start int) {
	if len(temp) == k {
		tempRes := make([]int, 0)
		for _, v := range temp {
			tempRes = append(tempRes, v)
		}
		result = append(result, tempRes)
		return
	}
	for i := start; i < len(nums); i++ {
		if _, ok := m[nums[i]]; !ok {
			temp = append(temp, nums[i])
			m[nums[i]] = nil
		}
		recursiveResult(temp, m, nums, start+1)
		delete(m, temp[len(temp)-1])
		temp = temp[:len(temp)-1]
	}
}

func Subsets(nums []int) [][]int {
	return helper(nums, 0)
}

func helper(nums []int, p int) [][]int {
	var result [][]int
	result = append(result, []int{})
	if p == len(nums) {
		return result
	}
	for i := p; i < len(nums); i++ {
		temp := helper(nums, i+1)
		for j := range temp {
			t := append([]int{nums[i]}, temp[j]...)
			result = append(result, t)
		}
	}
	return result
}
