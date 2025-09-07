package easy

func sumZero(n int) []int {
	arr := make([]int, n)
	k := 1

	for i := 0; i < n/2; i++ {
		arr[i] = k
		arr[n-i-1] = -k
		k++
	}
	return arr
}
