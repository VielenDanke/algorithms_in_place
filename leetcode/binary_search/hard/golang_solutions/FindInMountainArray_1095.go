package golang_solutions

type MountainArray struct {
}

func (this *MountainArray) get(index int) int {
	return -1
}
func (this *MountainArray) length() int {
	return -1
}

func findInMountainArray(target int, mountainArr *MountainArray) int {
	left, right := 0, mountainArr.length()

	maxSoFar := mountainArr.get(0)
	maxSoFarIdx := 0

	for left <= right {
		middle := left + (right-left)/2
		middleNum := mountainArr.get(middle)
		if middleNum > maxSoFar {
			maxSoFar = middleNum
			maxSoFarIdx = middle
		}
		if middle > 0 && mountainArr.get(middle-1) > middleNum {
			right = middle - 1
		} else if middle < mountainArr.length()-1 && mountainArr.get(middle+1) > middleNum {
			left = middle + 1
		} else {
			break
		}
	}
	if maxSoFar == target {
		return maxSoFarIdx
	}
	left, right = 0, maxSoFarIdx

	for left <= right {
		middle := left + (right-left)/2
		middleNum := mountainArr.get(middle)
		if middleNum == target {
			return middle
		} else if middleNum > target {
			right = middle - 1
		} else {
			left = middle + 1
		}
	}
	left, right = maxSoFarIdx, mountainArr.length()-1

	for left <= right {
		middle := left + (right-left)/2
		middleNum := mountainArr.get(middle)
		if middleNum == target {
			return middle
		} else if middleNum > target {
			left = middle + 1
		} else {
			right = middle - 1
		}
	}
	return -1
}
