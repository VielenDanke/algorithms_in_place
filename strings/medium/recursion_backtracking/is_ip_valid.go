package recursion_backtracking

import (
	"strconv"
	"strings"
)

func ValidIPAddresses(str string) []string {
	result := make([]string, 0)

	recursiveCollectIPs(&result, make([]string, 0), str, 0, min(len(str), 4))

	return result
}

func recursiveCollectIPs(result *[]string, temp []string, str string, p int, end int) {
	if p == 3 {
		if isIPPartValid(str[0:end]) {
			temp = append(temp, str[0:end])
		} else {
			return
		}
		*result = append(*result, strings.Join(temp, "."))
		return
	} else {
		for i := 0; i < end; i++ {
			if isIPPartValid(str[:i]) {
				temp = append(temp, str[:i])
				recursiveCollectIPs(result, temp, str[i:], p+1, min(len(str[i:]), i+4))
				temp = temp[:len(temp)-1]
			}
		}
	}
}

func min(f, s int) int {
	if f > s {
		return s
	}
	return f
}

func isIPPartValid(ipPart string) bool {
	if len(ipPart) == 0 {
		return false
	}
	if strings.HasPrefix(ipPart, "0") && len(ipPart) != 1 {
		return false
	}
	ip, _ := strconv.Atoi(ipPart)
	if ip >= 0 && ip <= 255 {
		return true
	}
	return false
}
