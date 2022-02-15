package easy

func containsNearbyDuplicate(nums []int, k int) bool {
	m := make(map[int]int)
	for idx, val := range nums {
		if idxValue, ok := m[val]; ok {
			if idx != idxValue && abs(idx, idxValue) <= k {
				return true
			}
		}
		m[val] = idx
	}
	return false
}

func abs(i, j int) int {
	if i-j > 0 {
		return i - j
	}
	return j - i
}
