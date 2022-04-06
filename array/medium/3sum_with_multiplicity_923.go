package medium

import (
	"fmt"
	"sort"
)

// TODO: have to finish

func ThreeSumMulti(arr []int, target int) (sum int) {
	sort.Ints(arr)

	repeatCounter := make(map[string]int)

	for i := 0; i < len(arr); i++ {
		left, right := i+1, len(arr)-1
		for left < right {
			tempSum := arr[left] + arr[right] + arr[i]

			if tempSum == target {
				repeatCounter[createSumKey(arr[i], arr[left], arr[right])]++
				left++
				right--
			} else if tempSum < target {
				left++
			} else {
				right--
			}
		}
	}
	for _, v := range repeatCounter {
		sum += v
	}
	return
}

func createSumKey(a, b, c int) string {
	return fmt.Sprintf("%d,%d,%d", a, b, c)
}
