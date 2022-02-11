package medium

func CheckInclusion(s1 string, s2 string) bool {
	sub := []rune(s1)
	text := []rune(s2)

	subSum := 0

	for _, v := range sub {
		subSum += int(v)
	}
	var temp []rune
	for i := 0; i+len(sub) <= len(text); i++ {
		temp = text[i : i+len(sub)]
		if checkIfPerm(sub, temp) {
			return true
		}
	}
	return false
}

func checkIfPerm(f, s []rune) bool {
	arr := make([]int, 26)

	for _, v := range f {
		arr[v-97]++
	}
	for _, v := range s {
		arr[v-97]--
	}
	for _, v := range arr {
		if v != 0 {
			return false
		}
	}
	return true
}
