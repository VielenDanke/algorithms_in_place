package golang_solutions

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
