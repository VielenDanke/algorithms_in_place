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

func permuteSecond(nums []int) [][]int {
	result := make([][]int, 0)
	backtrackPermuteSecond(&result, nums, 0)
	return result
}

func backtrackPermuteSecond(result *[][]int, nums []int, left int) {
	if left == len(nums) {
		copyOfArr := make([]int, len(nums))
		copy(copyOfArr, nums)
		*result = append(*result, copyOfArr)
		return
	}
	for i := left; i < len(nums); i++ {
		nums[left], nums[i] = nums[i], nums[left]
		backtrackPermuteSecond(result, nums, left+1)
		nums[left], nums[i] = nums[i], nums[left]
	}
}
