package medium

func Sort(arr []int) []int {
	if len(arr) <= 1 {
		return arr
	}
	f := Sort(arr[len(arr)/2:])
	s := Sort(arr[:len(arr)/2])
	return merge(f, s)
}

func merge(f []int, s []int) []int {
	var i, j int
	var result []int
	for i < len(f) && j < len(s) {
		if f[i] < s[j] {
			result = append(result, f[i])
			i++
		} else {
			result = append(result, s[j])
			j++
		}
	}
	for i < len(f) {
		result = append(result, f[i])
		i++
	}
	for j < len(s) {
		result = append(result, s[j])
		j++
	}
	return result
}
