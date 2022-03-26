package medium

func MinDominoRotations(tops []int, bottoms []int) int {
	maxTops := make(map[int]int)
	maxBottoms := make(map[int]int)
	maxTopsSame := 0
	maxBottomsSame := 0
	maxTopsSameNum := 0
	maxBottomsSameNum := 0

	for idx := 0; idx < len(tops); idx++ {
		maxTops[tops[idx]]++
		if maxTopsSame < maxTops[tops[idx]] {
			maxTopsSame = maxTops[tops[idx]]
			maxTopsSameNum = tops[idx]
		}
		maxBottoms[bottoms[idx]]++
		if maxBottomsSame < maxBottoms[bottoms[idx]] {
			maxBottomsSame = maxBottoms[bottoms[idx]]
			maxBottomsSameNum = bottoms[idx]
		}
	}
	if maxTopsSame > maxBottomsSame {
		for idx := range tops {
			if tops[idx] != maxTopsSameNum {
				if bottoms[idx] != maxTopsSameNum {
					return -1
				}
			}
		}
		return len(tops) - maxTopsSame
	} else if maxTopsSame < maxBottomsSame {
		for idx := range bottoms {
			if bottoms[idx] != maxBottomsSameNum {
				if tops[idx] != maxBottomsSameNum {
					return -1
				}
			}
		}
		return len(bottoms) - maxBottomsSame
	} else {
		isFound := true
		for idx := range tops {
			if tops[idx] != maxTopsSameNum {
				if bottoms[idx] != maxTopsSameNum {
					isFound = false
					break
				}
			}
		}
		if isFound {
			return len(tops) - maxTopsSame
		}
		isFound = true
		for idx := range bottoms {
			if bottoms[idx] != maxBottomsSameNum {
				if tops[idx] != maxBottomsSameNum {
					isFound = false
				}
			}
		}
		if isFound {
			return len(bottoms) - maxBottomsSame
		}
		return -1
	}
}
