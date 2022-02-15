package medium

func SubarraySum(nums []int, k int) (result int) {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		if nums[0] == k {
			return 1
		}
		return 0
	}
	left, right, sum := 0, 0, 0

	for right <= len(nums) && left <= len(nums) {
		if sum == k {
			result++
			sum -= nums[left]
			left++
		} else if sum < k && right < len(nums) {
			sum += nums[right]
			right++
		} else if sum > k && left < len(nums) {
			sum -= nums[left]
			left++
		} else {
			break
		}
	}
	return result
}

func SubarraySumMap(nums []int, k int) (result int) {
	sum := 0
	m := make(map[int]int)
	m[0] = 1

	for i := 0; i < len(nums); i++ {
		sum += nums[i]
		val, ok := m[sum-k]
		if ok {
			result += val
		}
		if _, sumOk := m[sum]; sumOk {
			m[sum]++
		} else {
			m[sum] = 1
		}
	}
	return result
}
