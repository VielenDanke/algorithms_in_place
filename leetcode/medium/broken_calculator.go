package medium

func BrokenCalc(startValue int, target int) (operations int) {
	for target > startValue {
		if target%2 == 0 {
			target /= 2
		} else {
			target++
		}
		operations++
	}
	return operations + (startValue - target)
}

func BrokenCalcRecursive(startValue, target int) (operations int) {
	if startValue >= target {
		return startValue - target
	}
	if target%2 == 0 {
		return 1 + BrokenCalcRecursive(startValue, target/2)
	}
	return 1 + BrokenCalc(startValue, target+1)
}
