package strings

import "fmt"

func RunLengthEncoding(str string) (result string) {
	// Write your code here.
	// check if length is empty
	// create temp variable for storing amount of letter
	// if it is more than 10 - start counter again
	// pointer to the start of string and move it along till the next letter would not be changed
	runes := []rune(str)
	if len(runes) == 0 {
		return
	}
	if len(runes) == 1 {
		result = "1" + string(runes[0])
	} else {
		counter := 1
		lastLetter := runes[0]
		for i := 1; i < len(runes); i++ {
			if runes[i] == lastLetter {
				counter++
			} else {
				result = helper(result, lastLetter, counter)
				lastLetter = runes[i]
				counter = 1
			}
		}
		result = helper(result, lastLetter, counter)
	}
	return
}

func helper(result string, lastLetter rune, counter int) string {
	maxNumberCount := 9
	if counter > maxNumberCount {
		// calculate the amount of 9s, for each 9 - append the same letter and number 9
		module := counter % maxNumberCount
		for counter > maxNumberCount {
			result += fmt.Sprintf("9%s", string(lastLetter))
			counter -= maxNumberCount
		}
		result += fmt.Sprintf("%d%s", module, string(lastLetter))
	} else {
		// append the result with counter + letter
		result += fmt.Sprintf("%d%s", counter, string(lastLetter))
	}
	return result
}
