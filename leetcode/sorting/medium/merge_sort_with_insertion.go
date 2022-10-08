package medium

func MergeSortWithInsertion(arr []int, k int) []int {
	if len(arr) <= k {
		insertionSortMerge(arr)
		return arr
	}
	left := MergeSortWithInsertion(arr[:(len(arr)-1)/2], k)
	right := MergeSortWithInsertion(arr[(len(arr)-1)/2:], k)
	return merge(left, right)
}

func insertionSortMerge(arr []int) {
	for i := 1; i < len(arr); i++ {
		current := arr[i]

		j := i - 1

		for j >= 0 && arr[j] > current {
			arr[j], arr[j+1] = arr[j+1], arr[j]
			j--
		}
	}
}
