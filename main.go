package main

import (
	"fmt"
	"strings"
)

func LevenshteinDistance(a, b string) (sum int) {
	idx := -1
	sum = 1 << 31
	for i := 0; i < len(a); i++ {
		idx = strings.IndexByte(b, a[i])
		if idx == -1 {
			continue
		}
		var tempSum int
		if idx != -1 {
			tempSum += idx
			fStr := b[idx:]
			sStr := a[i:]
			length := min(len(fStr), len(sStr))
			for j := 0; j < length; j++ {
				if fStr[j] != a[j] {
					tempSum++
				}
			}
			if sum > tempSum {
				sum = tempSum
			}
		}
	}
	return
}

func min(f, s int) int {
	if f > s {
		return s
	}
	return f
}

func main() {
	fmt.Printf("Result: %d\n", LevenshteinDistance("abc", "yabd"))
}
