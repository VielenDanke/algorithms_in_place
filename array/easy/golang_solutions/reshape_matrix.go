package golang_solutions

func MatrixReshape(mat [][]int, r int, c int) [][]int {
	if r*c != len(mat)*len(mat[0]) {
		return mat
	}
	result := make([][]int, 0)

	for i := 0; i < r; i++ {
		temp := make([]int, 0)
		var elem int
		var isLast bool
		for j := 0; j < c; j++ {
			elem, mat, isLast = fetchNextElement(mat)
			temp = append(temp, elem)
			if isLast {
				break
			}
		}
		result = append(result, temp)
		if isLast {
			break
		}
	}
	return result
}

func fetchNextElement(mat [][]int) (int, [][]int, bool) {
	elem := mat[0][0]
	if len(mat) == 1 && len(mat[0]) == 1 {
		return mat[0][0], mat, true
	}
	if len(mat[0]) == 1 {
		mat = mat[1:]
	} else {
		mat[0] = mat[0][1:]
	}
	return elem, mat, false
}
