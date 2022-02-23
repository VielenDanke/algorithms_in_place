package easy

import (
	"fmt"
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

func insertIntervalsFree(interviewer [][]int, candidate [][]int) [][]int {
	for _, v := range candidate {
		interviewer = append(interviewer, v)
	}
	sort.Slice(interviewer, func(i, j int) bool {
		return interviewer[i][0] < interviewer[j][0]
	})
	resultIntervals := make([][]int, 0)
	for _, v := range interviewer {
		if len(resultIntervals) == 0 || resultIntervals[len(resultIntervals)-1][1] < v[0] {
			resultIntervals = append(resultIntervals, v)
		} else {
			resultIntervals[len(resultIntervals)-1][1] = max(resultIntervals[len(resultIntervals)-1][1], v[1])
		}
	}
	return resultIntervals
}

func FindFreeTime(interviewer [][]int, candidate [][]int) [][]int {
	start := 0
	end := 1
	resultIntervals := insertIntervalsFree(interviewer, candidate)
	freeIntervals := make([][]int, 0)
	for i := 0; i < len(resultIntervals)-1; i++ {
		freeIntervals = append(freeIntervals, []int{resultIntervals[start][1], resultIntervals[end][0]})
	}
	return resultIntervals
}

func max(f, s int) int {
	fmt.Println(3 / 2)
	if f > s {
		return f
	}
	return s
}
