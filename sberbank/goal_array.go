package sberbank

func GetResult(arrayStart []int, arrayGoal []int) (counter int) {
	for i := range arrayGoal {
		if arrayStart[i] != arrayGoal[i] {
			for j := range arrayStart {
				if arrayGoal[i] == arrayStart[j] {
					counter++
					arrayStart[j], arrayStart[i] = arrayStart[i], arrayStart[j]
					break
				}
			}
		}
	}
	return
}

func GetResult2(arrayStart []int, arrayGoal []int) (counter int) {
	ignoreMap := make(map[int]interface{})
	for i := range arrayGoal {
		_, ok := ignoreMap[arrayGoal[i]]
		if arrayStart[i] != arrayGoal[i] && !ok {
			counter++
			ignoreMap[arrayStart[i]] = nil
		}
	}
	return
}
