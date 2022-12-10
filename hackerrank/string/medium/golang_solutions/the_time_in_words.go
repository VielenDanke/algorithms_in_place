package golang_solutions

import "fmt"

var mapper map[int32]string

func init() {
	mapper = make(map[int32]string)
	mapper[1] = "one"
	mapper[2] = "two"
	mapper[3] = "three"
	mapper[4] = "four"
	mapper[5] = "five"
	mapper[6] = "six"
	mapper[7] = "seven"
	mapper[8] = "eight"
	mapper[9] = "nine"
	mapper[10] = "ten"
	mapper[11] = "eleven"
	mapper[12] = "twelwe"
	mapper[13] = "thirteen"
	mapper[14] = "fourteen"
	mapper[15] = "fifteen"
	mapper[16] = "sixteen"
	mapper[17] = "seventeen"
	mapper[18] = "eighteen"
	mapper[19] = "nineteen"
	mapper[20] = "twenty"
	mapper[21] = "twenty one"
	mapper[22] = "twenty two"
	mapper[23] = "twenty three"
	mapper[24] = "twenty four"
	mapper[25] = "twenty five"
	mapper[26] = "twenty six"
	mapper[27] = "twenty seven"
	mapper[28] = "twenty eight"
	mapper[29] = "twenty nine"
}

func timeInWords(h int32, m int32) string {
	// Write your code here
	if m == 0 {
		return fmt.Sprintf("%s o' clock", mapper[h])
	}
	if m == 30 {
		return fmt.Sprintf("half past %s", mapper[h])
	}
	if m%15 == 0 {
		if m < 30 {
			return fmt.Sprintf("quarter past %s", mapper[h])
		} else {
			var hour string
			if h+1 > 12 {
				hour = mapper[1]
			} else {
				hour = mapper[h+1]
			}
			return fmt.Sprintf("quarter to %s", hour)
		}
	}
	if m < 30 {
		var minute string
		if m == 1 {
			minute = "minute"
		} else {
			minute = "minutes"
		}
		return fmt.Sprintf("%s %s past %s", mapper[m], minute, mapper[h])
	}
	var hour string
	if h+1 > 12 {
		hour = mapper[1]
	} else {
		hour = mapper[h+1]
	}
	return fmt.Sprintf("%s minutes to %s", mapper[60-m], hour)
}
