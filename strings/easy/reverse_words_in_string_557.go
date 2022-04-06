package easy

import "bytes"

func reverseWords(s string) string {
	if s == "" {
		return s
	}
	buff := bytes.NewBufferString("")

	start := 0

	for idx := range s {
		if s[idx] == ' ' {
			buff.WriteString(reverseWord([]rune(s[start:idx])))
			buff.WriteRune(' ')
			start = idx + 1
		}
	}
	buff.WriteString(reverseWord([]rune(s[start:len(s)])))
	return buff.String()
}

func reverseWord(s []rune) string {
	left, right := 0, len(s)-1

	for left < right {
		s[left], s[right] = s[right], s[left]
		left++
		right--
	}
	return string(s)
}
