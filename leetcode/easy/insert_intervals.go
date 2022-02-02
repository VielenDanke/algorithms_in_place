package easy

import (
	"math"
	"sort"
)

/*
1. Iterate over the intervals
2. if interval[i] covers new interval - return intervals itself
3. if interval covers start - take interval[i][0]
4. if interval covers end - take interval[i][1]
5. store the idx of start and idx of end interval - cut all and insert new interval and return intervals
*/

func InsertIntervals(intervals [][]int, newInterval []int) [][]int {
	if len(intervals) == 0 {
		return [][]int{newInterval}
	}
	intervals = append(intervals, newInterval)
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	resultIntervals := make([][]int, 0)
	for _, v := range intervals {
		if len(resultIntervals) == 0 || (resultIntervals[len(resultIntervals)-1][1] < v[0]) {
			resultIntervals = append(resultIntervals, v)
		} else {
			resultIntervals[len(resultIntervals)-1][1] = int(math.Max(float64(resultIntervals[len(resultIntervals)-1][1]), float64(v[1])))
		}
	}
	return resultIntervals
}
