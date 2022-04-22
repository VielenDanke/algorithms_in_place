package golang_solutions

import "math"

func champagneTower(poured int, queryRow int, queryGlass int) float64 {
	tower := [102][102]float64{}
	tower[0][0] = float64(poured)
	for row := 0; row <= queryRow; row++ {
		for column := 0; column <= row; column++ {
			next := (tower[row][column] - 1.0) / 2.0
			if next > 0 {
				tower[row+1][column] += next
				tower[row+1][column+1] += next
			}
		}
	}
	return math.Min(float64(1), tower[queryRow][queryGlass])
}
