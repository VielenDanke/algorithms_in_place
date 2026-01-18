package golang_solutions

import "math"

func separateSquares(squares [][]int) float64 {
	maxY, totalArea := 0.0, 0.0
	for _, sq := range squares {
		y, l := sq[1], sq[2]
		totalArea += float64(l * l)
		if float64(y+l) > maxY {
			maxY = float64(y + l)
		}
	}

	check := func(limitY float64) bool {
		area := 0.0
		for _, sq := range squares {
			y, l := sq[1], sq[2]
			if float64(y) < limitY {
				overlap := math.Min(limitY-float64(y), float64(l))
				area += float64(l) * overlap
			}
		}

		return area >= totalArea/2.0
	}

	lo, hi := 0.0, maxY
	eps := 1e-5
	for math.Abs(hi-lo) > eps {
		mid := (hi + lo) / 2.0
		if check(mid) {
			hi = mid
		} else {
			lo = mid
		}
	}
	return hi
}
