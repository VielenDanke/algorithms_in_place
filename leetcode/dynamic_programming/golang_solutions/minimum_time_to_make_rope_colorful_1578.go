package golang_solutions

import "math"

// iterative

func minCost(colors string, neededTime []int) int {
	max, total, result := neededTime[0], neededTime[0], 0
	for i := range colors {
		if i > 0 {
			if colors[i-1] == colors[i] {
				max = int(math.Max(float64(max), float64(neededTime[i])))
				total += neededTime[i]
			} else {
				result += total - max
				total, max = neededTime[i], neededTime[i]
			}
		}
	}
	return result + (total - max)
}

// recursive

func minCostRecursive(colors string, neededTime []int) int {
	return recursiveRope(colors, neededTime, 0)
}

func recursiveRope(colors string, neededTime []int, idx int) int {
	if idx == len(colors)-1 {
		return 0
	}
	if colors[idx] == colors[idx+1] {
		if neededTime[idx+1] < neededTime[idx] {
			neededTime[idx], neededTime[idx+1] = neededTime[idx+1], neededTime[idx]
		}
		return int(math.Min(float64(neededTime[idx]), float64(neededTime[idx+1]))) + recursiveRope(colors, neededTime, idx+1)
	}
	return recursiveRope(colors, neededTime, idx+1)
}
