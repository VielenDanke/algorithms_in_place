package easy

func LengthOfLastWord2(s string) (length int) {
	chs := []rune(s)

	var isAccessed bool

	for i := len(chs) - 1; i >= 0; i-- {
		if !((chs[i] >= 65 && chs[i] <= 90) || (chs[i] >= 97 && chs[i] <= 122)) {
			if isAccessed {
				break
			}
			chs = chs[:i]
		} else {
			isAccessed = true
			length++
		}
	}
	return
}

func LengthOfLastWord(s string) (length int) {
	chs := []rune(s)
	for i := len(chs) - 1; i >= 0; i-- {
		if !((chs[i] >= 65 && chs[i] <= 90) || (chs[i] >= 97 && chs[i] <= 122)) {
			chs = chs[:i]
		} else {
			break
		}
	}
	for i := len(chs) - 1; i >= 0; i-- {
		if !((chs[i] >= 65 && chs[i] <= 90) || (chs[i] >= 97 && chs[i] <= 122)) {
			break
		} else {
			length++
		}
	}
	return
}
