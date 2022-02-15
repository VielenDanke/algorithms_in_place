package main

func StaircaseTraversal(height int, maxSteps int) int {
	// Write your code here.
	return stepUp(height, maxSteps, make(map[int]int))
}

func stepUp(height int, maxSteps int, m map[int]int) int {
	if val, ok := m[height]; ok {
		return val
	}
	if height <= 1 {
		return 1
	}
	sum := 0
	for step := 1; step < min(maxSteps, height)+1; step++ {
		sum += stepUp(height-step, maxSteps, m)
	}
	m[height] = sum
	return sum
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
