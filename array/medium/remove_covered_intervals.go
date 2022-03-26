package medium

import "sort"

func RemoveCoveredIntervalsSecond(intervals [][]int) int {
	sort.Slice(intervals, func(i, j int) bool {
		if intervals[i][0] == intervals[j][0] {
			return intervals[i][1] > intervals[j][1]
		}
		return intervals[i][0] < intervals[j][0]
	})
	covered := 0
	end := -1

	for _, interval := range intervals {
		if interval[1] <= end {
			covered++
		} else {
			end = interval[1]
		}
	}
	return len(intervals) - covered
}
