package golang_solutions

import "sort"

func frequencySort(s string) string {
	alph := make([]int, 256)

	for _, v := range s {
		alph[v+'A']++
	}
	arr := make([][]int, 0)

	for i, v := range alph {
		if v != 0 {
			arr = append(arr, []int{v, i - 'A'})
		}
	}
	sort.Slice(arr, func(i, j int) bool {
		return arr[i][0] > arr[j][0]
	})
	result := make([]rune, 0)

	for _, v := range arr {
		for i := 0; i < v[0]; i++ {
			result = append(result, rune(v[1]))
		}
	}
	return string(result)
}
