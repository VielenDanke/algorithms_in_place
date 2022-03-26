package medium

func Permute(str string) []string {
	runes := []rune(str)
	result := make([]string, 0)
	permute(&result, runes, 0, len(runes))
	return result
}

func permute(result *[]string, temp []rune, left int, right int) {
	if left == right {
		*result = append(*result, string(temp))
		return
	} else {
		for i := left; i < right; i++ {
			temp[left], temp[i] = temp[i], temp[left]
			permute(result, temp, left+1, right)
			temp[left], temp[i] = temp[i], temp[left]
		}
	}
}
