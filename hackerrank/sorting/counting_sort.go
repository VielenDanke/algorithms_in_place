package sorting

func countingSort(arr []int32) []int32 {
	// Write your code here
	max := int32(-1 << 30)
	for _, v := range arr {
		if max < v {
			max = v
		}
	}
	toSort := make([]int32, max+1)

	for _, v := range arr {
		toSort[v]++
	}
	idx := 0
	for i, v := range toSort {
		for v > 0 {
			arr[idx] = int32(i)
			idx++
			v--
		}
	}
	return arr
}
