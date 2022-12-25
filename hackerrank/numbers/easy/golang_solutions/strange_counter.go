package golang_solutions

import "math"

func strangeCounter(t int64) int64 {
	initValue := 3
	time := int(t)
	for time-initValue > 0 {
		time -= initValue
		initValue *= 2
	}
	return int64(math.Abs(float64(time-initValue))) + 1
}

func strangeCounterBruteForce(t int64) int64 {
	initValue := 3
	temp := initValue

	for t > 1 {
		t--
		temp--
		if temp == 0 {
			initValue *= 2
			temp = initValue
		}
	}
	return int64(temp)
}
