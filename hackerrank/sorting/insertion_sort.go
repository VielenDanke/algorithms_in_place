package sorting

import "fmt"

func sort(arr []int) {
	for i := 1; i < len(arr); i++ {
		key := arr[i]
		j := i - 1
		for j >= 0 && key < arr[j] {
			arr[j+1] = arr[j]
			printSlice(arr)
			println()
			j--
		}
		arr[j+1] = key
		print(arr)
	}
}

func printSlice(arr []int) {
	for i, v := range arr {
		if i < len(arr)-1 {
			fmt.Printf("%d ", v)
		} else {
			fmt.Printf("%d", v)
		}
	}
}
