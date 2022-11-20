package golang_solutions

func intersection(nums1 []int, nums2 []int) []int {
	m := make(map[int]interface{})
	for _, v := range nums1 {
		m[v] = nil
	}
	result := make([]int, 0)
	for _, v := range nums2 {
		if _, ok := m[v]; ok {
			result = append(result, v)
			delete(m, v)
		}
	}
	return result
}
