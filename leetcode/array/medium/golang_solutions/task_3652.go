package golang_solutions

func CallMaxProfit(prices []int, strategy []int, k int) int64 {
	return maxProfit(prices, strategy, k)
}

func maxProfit(prices []int, strategy []int, k int) int64 {
	n := len(strategy)

	prefixSum := make([]int64, n)

	prefixSum[0] = int64(prices[0] * strategy[0])
	maxVal := prefixSum[0]

	maxFunc := func(a, b int64) int64 {
		if a > b {
			return a
		}
		return b
	}

	for i := 1; i < n; i++ {
		prefixSum[i] = prefixSum[i-1] + int64(prices[i]*strategy[i])
		maxVal += int64(prices[i] * strategy[i])
	}

	for i := 0; i+k <= n; i++ {
		end := i + k

		windowProfit := int64(0)
		counter := 0
		for j := i; j < end; j++ {
			if counter < k/2 {
				windowProfit += int64(0 * prices[j])
			} else {
				windowProfit += int64(1 * prices[j])
			}
			counter++
		}

		if i > 0 {
			windowProfit += prefixSum[i-1]
		}

		if end < n {
			windowProfit += prefixSum[n-1] - prefixSum[end-1]
		}

		maxVal = maxFunc(maxVal, windowProfit)
	}
	return maxVal
}

func maxProfitFaster(prices []int, strategy []int, k int) int64 {
	n := len(prices)
	mid := k / 2

	// We will track the "Delta" (change) relative to this base profit.
	baseProfit := int64(0)
	for i := 0; i < n; i++ {
		baseProfit += int64(prices[i] * strategy[i])
	}

	if k > n {
		return baseProfit
	}

	// 2. Calculate the Delta for the Initial Window [0 ... k-1]
	currentDelta := int64(0)
	for i := 0; i < k; i++ {
		originalVal := int64(prices[i] * strategy[i])

		if i < mid {
			// First Half: Force Hold (0)
			// Change = New(0) - Original
			currentDelta += 0 - originalVal
		} else {
			// Second Half: Force Sell (1)
			// Change = New(price) - Original
			currentDelta += int64(prices[i]) - originalVal
		}
	}

	// Initialize maxDelta. It must be at least 0 (we can choose to do nothing)
	maxDelta := int64(0)
	if currentDelta > 0 {
		maxDelta = currentDelta
	}

	// 3. Slide the window from index 1 to n-k
	for i := 1; i <= n-k; i++ {
		// Indices involved in the shift:
		leavingIdx := i - 1      // Element leaving the window (was in Hold section)
		midIdx := i - 1 + mid    // Element moving from Sell -> Hold section
		enteringIdx := i + k - 1 // Element entering the window (into Sell section)

		// A. Handle Leaving Element (Remove 'Hold' effect)
		// Previous delta contribution was (0 - original). To remove it: subtract (0 - original) => add original.
		currentDelta += int64(prices[leavingIdx] * strategy[leavingIdx])

		// B. Handle Middle Element (Shift Sell -> Hold)
		// Previous delta contribution: (price - original)
		// New delta contribution:      (0 - original)
		// Net change: (0 - original) - (price - original) = -price
		currentDelta -= int64(prices[midIdx])

		// C. Handle Entering Element (Add 'Sell' effect)
		// New delta contribution: (price - original)
		currentDelta += int64(prices[enteringIdx]) - int64(prices[enteringIdx]*strategy[enteringIdx])

		// Update Max
		if currentDelta > maxDelta {
			maxDelta = currentDelta
		}
	}

	return baseProfit + maxDelta
}
