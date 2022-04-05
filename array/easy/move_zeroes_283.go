package easy

// O(N) time | O(1) space | 77.50% time 65.97% space

func moveZeroes(nums []int) {
	zeroCounter := 0

	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			nums[i-zeroCounter] = nums[i]
		} else {
			zeroCounter++
		}
	}
	for i := len(nums) - 1; i >= 0; i-- {
		if zeroCounter > 0 {
			nums[i] = 0
			zeroCounter--
		} else {
			break
		}
	}
}

// Failed solution, but could be helpful if order is not necessary
// O(N) time | O(1) space

func moveZeroesWithoutMaintainingOrder(nums []int) {
	left, right := 0, len(nums)-1

	for left < right {
		if nums[left] != 0 {
			left++
		} else if nums[right] == 0 {
			right--
		} else {
			nums[left], nums[right] = nums[right], nums[left]
		}
	}
}

// O(N) time | O(N) space | 98.41% time 65.97% space

func moveZeroesExtraMemory(nums []int) {
	nonZeroArray := make([]int, len(nums))

	idxCounter := 0

	for _, v := range nums {
		if v != 0 {
			nonZeroArray[idxCounter] = v
			idxCounter++
		}
	}
	for idx := range nonZeroArray {
		nums[idx] = nonZeroArray[idx]
	}
}

// O(N^2) time | O(1) space

func moveZeroesBruteForce(nums []int) {
	isSorted := false

	for !isSorted {
		isSorted = true
		for i := 0; i < len(nums)-1; i++ {
			if nums[i] == 0 && nums[i+1] != 0 {
				nums[i], nums[i+1] = nums[i+1], nums[i]
				isSorted = false
			}
		}
	}
}
