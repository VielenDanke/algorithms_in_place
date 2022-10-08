package golang_solutions

func HasSingleCycle(array []int) bool {
	// Write your code here.
	// create arr isVisited
	// create counter
	// jump over leetcode.array
	// mark node as visited
	// if visited node is being visited by pointer
	// = check counter == len(leetcode.array) ? return true : return false
	visitedArr := make([]bool, len(array))
	counter := 0
	currentIdx := 0

	for counter < len(array) {
		currentIdx = getNextIdx(array, currentIdx)
		if visitedArr[currentIdx] {
			return false
		} else {
			visitedArr[currentIdx] = true
			counter++
		}
	}
	return true
}

func getNextIdx(array []int, currentIdx int) int {
	jump := array[currentIdx]
	nextIdx := (currentIdx + jump) % len(array)
	if nextIdx >= 0 {
		return nextIdx
	}
	return nextIdx + len(array)
}
