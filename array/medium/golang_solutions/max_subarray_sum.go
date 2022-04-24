package golang_solutions

func MaxSubarraySum(arr []int, sum int) []int {
	start := 0
	end := 1
	tempSum := 0
	tempSum += arr[start]
	tempSum += arr[end]
	end++
	maxRange := 0
	maxStart := 0
	maxEnd := 0
	for end < len(arr) {
		s := tempSum + arr[end]
		if s > sum {
			tempSum -= arr[start]
			start++
		} else if s < sum {
			tempSum += arr[end]
			end++
		} else {
			tempSum += arr[end]
			if maxRange < end-start {
				maxStart = start
				maxEnd = end
				maxRange = end - start
			}
			end++
		}
	}
	return []int{maxStart + 1, maxEnd + 1}
}
