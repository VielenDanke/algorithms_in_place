package golang_solutions

// gcd finds the greatest common divisor of two integers.
func gcd(a, b int) int {
	for b != 0 {
		a, b = b, a%b
	}
	return a
}

// minOperations calculates the minimum operations to make all elements 1.
func minOperations(nums []int) int {
	n := len(nums)
	ones := 0

	// 1. Count existing 1s
	for _, num := range nums {
		if num == 1 {
			ones++
		}
	}

	// Case 1: The array already contains at least one 1.
	// We can spread the 1s to the rest of the array.
	// We have 'n - ones' elements to turn into 1.
	if ones > 0 {
		return n - ones
	}

	// Case 2: No 1s exist. We must create one.
	// We need to find the shortest subarray nums[i...j] such that gcd(nums[i...j]) == 1.
	// The cost to create a 1 from this subarray is 'length - 1'.
	// The shortest subarray will give the minimum cost.

	minLen := n + 1 // Use n+1 as a stand-in for "infinity"

	// Iterate through all possible starting points
	for i := 0; i < n; i++ {
		g := nums[i]
		// Check all subarrays starting at i
		for j := i + 1; j < n; j++ {
			g = gcd(g, nums[j])
			if g == 1 {
				// We found a subarray (from i to j) with gcd 1
				length := j - i + 1
				if length < minLen {
					minLen = length
				}
				// Since we are looking for the shortest starting at i,
				// we can break once we find the first one.
				break
			}
		}
	}

	// Case 3: Impossible to make 1s.
	// If minLen was never updated, it means no subarray has a gcd of 1.
	// This happens if the gcd of the entire array is > 1.
	if minLen == n+1 {
		return -1
	}

	// Total operations = (ops to create first 1) + (ops to spread that 1)
	// Ops to create = minLen - 1
	// Ops to spread = n - 1
	return (minLen - 1) + (n - 1)
}
