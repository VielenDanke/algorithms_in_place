package golang_solutions

import (
	"strconv"
	"strings"
)

func RestoreIpAddresses(s string) []string {
	result := make([]string, 0)
	helper(&result, make([]string, 0), s)
	return result
}

func helper(result *[]string, temp []string, s string) {
	if len(temp) == 4 && len(s) == 0 {
		*result = append(*result, strings.Join(temp, "."))
		return
	}
	if len(temp) == 4 || len(temp) > 3*(4-len(temp)) || len(s) < (4-len(temp)) {
		return
	}
	for i := 1; i <= 3; i++ {
		if i > len(s) {
			continue
		}
		num, _ := strconv.Atoi(s[:i])
		if s[:i] != strconv.Itoa(num) || num > 255 {
			continue
		}
		temp = append(temp, s[:i])
		helper(result, temp, s[i:])
		temp = temp[:len(temp)-1]
	}
}
