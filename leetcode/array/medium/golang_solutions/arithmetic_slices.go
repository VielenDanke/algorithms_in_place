package golang_solutions

func numberOfArithmeticSlices2(nums []int) (amount int) {
	for i, prev := 2, 0; i < len(nums); i++ {
		if nums[i]-nums[i-1] == nums[i-1]-nums[i-2] {
			prev++
			amount += prev
		} else {
			prev = 0
		}
	}
	return
}

func numberOfArithmeticSlices(nums []int) (amount int) {
	if len(nums) < 3 {
		return
	}
	length := 3
	for length < len(nums) {
		for i := 0; i+length <= len(nums); i++ {
			subArray := nums[i : i+length]
			if isValidArithmetic(subArray) {
				amount++
			}
		}
		length++
	}
	if isValidArithmetic(nums) {
		amount++
	}
	return
}

func isValidArithmetic(nums []int) bool {
	diff := nums[1] - nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i]-nums[i-1] != diff {
			return false
		}
	}
	return true
}
