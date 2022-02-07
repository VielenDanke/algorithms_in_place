package recursion

func NumWays(n int) int {
	if n == 0 || n == 1 {
		return 1
	} else {
		return NumWays(n-1) + NumWays(n-2)
	}
}

func NumWaysDynamic(n int) int {
	if n == 0 || n == 1 {
		return 1
	} else {
		nums := make([]int, n)
		nums = append(nums, 1, 1)
		for i := 2; i < n; i++ {
			nums[i] = nums[i-1] + nums[i-2]
		}
		return nums[n]
	}
}
