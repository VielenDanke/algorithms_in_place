package golang_solutions

func minOperations(nums []int) (counter int) {
	temp := make([]int, 0)
	for _, num := range nums {
		for len(temp) > 0 && temp[len(temp)-1] > num {
			temp = temp[:len(temp)-1]
		}
		if num == 0 {
			continue
		}
		if len(temp) == 0 || temp[len(temp)-1] < num {
			counter++
			temp = append(temp, num)
		}
	}
	return
}

func minOperationsBruteForce(nums []int) (counter int) {
	for {
		left, right := 0, 0
		minNum := 1 << 30

		for left < len(nums) && nums[left] == 0 {
			left++
		}
		right = left

		for right < len(nums) && nums[right] != 0 {
			if minNum > nums[right] {
				minNum = nums[right]
			}
			right++
		}
		right--
		isFound := false

		for i := left; i <= right; i++ {
			if nums[i] == minNum {
				nums[i] = 0
				isFound = true
			}
		}
		if !isFound {
			break
		}
		counter++
	}
	return
}
