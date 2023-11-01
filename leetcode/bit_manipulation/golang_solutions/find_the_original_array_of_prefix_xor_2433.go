package golang_solutions

func findArray(pref []int) []int {
	result := make([]int, len(pref))
	result[0] = pref[0]
	for i := 1; i < len(pref); i++ {
		result[i] = pref[i] ^ pref[i-1]
	}
	return result
}
