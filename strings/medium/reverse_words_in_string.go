package medium

func ReverseWordsInString2(str string) string {
	stack := make([]string, 0)

	startWord := 0
	for idx, character := range str {
		if character == ' ' {
			stack = append(stack, str[startWord:idx])
			startWord = idx
		} else if str[startWord] == ' ' {
			stack = append(stack, " ")
			startWord = idx
		}
	}
	stack = append(stack, str[startWord:])
	result := ""
	for len(stack) > 0 {
		var temp string
		if stack[len(stack)-1] == " " {
			for len(stack) > 0 && stack[len(stack)-1] == " " {
				temp += " "
				stack = stack[:len(stack)-1]
			}
		} else {
			temp += stack[len(stack)-1]
			stack = stack[:len(stack)-1]
		}
		result += temp
	}
	return result
}

func ReverseWordsInString(str string) string {
	stack := make([]string, 0)

	start, end, tabCounter := 0, 0, 0

	for end < len(str) {
		if str[end] != ' ' {
			end++
		} else {
			if tabCounter != 0 {
				temp := str[start:end]
				for tabCounter != 0 {
					temp += " "
					tabCounter--
				}
				stack = append(stack, temp)
			} else {
				stack = append(stack, str[start:end])
			}
			for end < len(str)-1 && str[end] == ' ' {
				end++
				tabCounter++
			}
			start = end
			end++
		}
	}
	if tabCounter != 0 {
		temp := str[start:end]
		for tabCounter != 0 {
			temp += " "
			tabCounter--
		}
		stack = append(stack, temp)
	} else {
		stack = append(stack, str[start:end])
	}
	result := ""
	for len(stack) > 0 {
		result += stack[len(stack)-1]
		stack = stack[:len(stack)-1]
	}
	return result
}
