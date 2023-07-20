package medium

func nearlySimilarRectangles(sides [][]int64) int64 {
	ratioCount := make(map[float64]int)

	for _, side := range sides {
		ratio := calculateRatio(side)
		ratioCount[ratio]++
	}
	var totalCount int64

	for _, count := range ratioCount {
		totalCount += int64(count*(count-1)) / 2
	}

	return totalCount
}

func calculateRatio(side []int64) float64 {
	return float64(side[0]) / float64(side[1])
}
