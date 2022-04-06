package medium

import (
	"fmt"
	"sort"
)

func ThreeSumMulti(arr []int, target int) (sum int) {
	mod := 1_000_000_007
	sort.Ints(arr)

	for i := 0; i < len(arr); i++ {
		left, right := i+1, len(arr)-1
		for left < right {
			tempSum := arr[left] + arr[right] + arr[i]

			if tempSum > target {
				right--
			} else if tempSum < target {
				left++
			} else if arr[left] != arr[right] {
				l, r := 1, 1

				for left+1 < right && arr[left] == arr[left+1] {
					left++
					l++
				}
				for right-1 > left && arr[right] == arr[right-1] {
					right--
					r++
				}
				sum += l * r
				sum %= mod
				left++
				right--
			} else {
				sum += (right - left + 1) * (right - left) / 2
				sum %= mod
				break
			}
		}
	}
	return
}

func createSumKey(a, b, c int) string {
	return fmt.Sprintf("%d,%d,%d", a, b, c)
}
