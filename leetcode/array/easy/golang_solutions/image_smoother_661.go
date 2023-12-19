package golang_solutions

var neighbors = [][]int{{1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}}

func imageSmoother(img [][]int) [][]int {
	result := make([][]int, len(img))
	for i := range result {
		result[i] = make([]int, len(img[0]))
	}
	for i := range img {
		for j := range img[i] {
			result[i][j] = round(img, i, j)
		}
	}
	return result
}

func round(img [][]int, i, j int) int {
	counter, sum := 1, img[i][j]
	for _, neighbor := range neighbors {
		nextRow, nextCol := i+neighbor[0], j+neighbor[1]
		if isValid(img, nextRow, nextCol) {
			counter++
			sum += img[nextRow][nextCol]
		}
	}
	return sum / counter
}

func isValid(img [][]int, i, j int) bool {
	return i >= 0 && j >= 0 && i < len(img) && j < len(img[0])
}
