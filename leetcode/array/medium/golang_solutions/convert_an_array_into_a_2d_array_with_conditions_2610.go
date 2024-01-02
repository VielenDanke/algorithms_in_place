package golang_solutions

// faster

func findMatrix(nums []int) [][]int {
	arr := make([]int, 201)

	for _, num := range nums {
		arr[num]++
	}
	matrix := make([][]int, 0)

	isRun := true

	for isRun {
		isRun = false

		temp := make([]int, 0)

		for num, counter := range arr {
			if counter > 0 {
				temp = append(temp, num)
				arr[num]--
				isRun = true
			}
		}
		if isRun {
			matrix = append(matrix, temp)
		}
	}
	return matrix
}

// slower because of lookup in map

func findMatrixMap(nums []int) [][]int {
	counter := make(map[int]int)

	for _, num := range nums {
		counter[num]++
	}
	matrix := make([][]int, 0)

	isRun := true

	for isRun {
		isRun = false

		temp := make([]int, 0)

		for num, n := range counter {
			if n > 0 {
				temp = append(temp, num)
				counter[num]--
				isRun = true
			}
		}
		if isRun {
			matrix = append(matrix, temp)
		}
	}
	return matrix
}
