package medium

import "sort"

func TaskAssignment(k int, tasks []int) [][]int {
	// Write your code here.
	result := make([][]int, 0)
	durationWithIndices := getTaskDurationMap(tasks)

	sort.Ints(tasks)

	start, end := 0, len(tasks)-1

	for start < end {
		startDur := tasks[start]
		endDur := tasks[end]

		pairStartIdx := durationWithIndices[startDur][len(durationWithIndices[startDur])-1]
		durationWithIndices[startDur] = durationWithIndices[startDur][:len(durationWithIndices[startDur])-1]

		pairEndIdx := durationWithIndices[endDur][len(durationWithIndices[endDur])-1]
		durationWithIndices[endDur] = durationWithIndices[endDur][:len(durationWithIndices[endDur])-1]

		result = append(result, []int{pairStartIdx, pairEndIdx})

		end--
		start++
	}
	return result
}

func getTaskDurationMap(tasks []int) map[int][]int {
	temp := make(map[int][]int)
	for idx, v := range tasks {
		temp[v] = append(temp[v], idx)
	}
	return temp
}
