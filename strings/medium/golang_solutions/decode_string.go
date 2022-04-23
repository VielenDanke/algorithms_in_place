package golang_solutions

type decoder struct {
	letters []rune
	count   int
}

func (e decoder) decodeEncoding() []rune {
	result := make([]rune, 0)
	for i := 0; i < e.count; i++ {
		result = append(result, e.letters...)
	}
	return result
}

func DecodeString(s string) string {
	runes := []rune(s)
	stack := make([]*decoder, 0)
	count := 0
	result := make([]rune, 0)
	var top *decoder
	for i := 0; i < len(runes); i++ {
		if runes[i] >= '0' && runes[i] <= '9' {
			count = count*10 + int(runes[i]-'0')
		}
		if runes[i] == '[' {
			stack = append(stack, &decoder{count: count})
			count = 0
		}
		if runes[i] >= 'a' && runes[i] <= 'z' {
			if len(stack) != 0 {
				stack[len(stack)-1].letters = append(stack[len(stack)-1].letters, runes[i])
			} else {
				result = append(result, runes[i])
			}
		}
		if runes[i] == ']' {
			top, stack = stack[len(stack)-1], stack[:len(stack)-1]
			temp := top.decodeEncoding()
			if len(stack) != 0 {
				stack[len(stack)-1].letters = append(stack[len(stack)-1].letters, temp...)
			} else {
				result = append(result, temp...)
			}
		}
	}
	return string(result)
}
