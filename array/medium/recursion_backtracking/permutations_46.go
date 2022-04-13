package recursion_backtracking

func permute(nums []int) [][]int {
	result := make([][]int, 0)
	visited := make([]bool, len(nums))
	backtrackPermute(&result, nums, make([]int, 0), visited)
	return result
}

func backtrackPermute(result *[][]int, nums []int, temp []int, visited []bool) {
	if len(temp) == len(nums) {
		copyOfArr := make([]int, len(nums))
		copy(copyOfArr, temp)
		*result = append(*result, copyOfArr)
		return
	}
	for i := 0; i < len(nums); i++ {
		if visited[i] {
			continue
		}
		visited[i] = true
		temp = append(temp, nums[i])
		backtrackPermute(result, nums, temp, visited)
		temp = temp[:len(temp)-1]
		visited[i] = false
	}
}
