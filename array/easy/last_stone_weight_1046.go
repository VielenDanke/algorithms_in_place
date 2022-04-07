package easy

import "sort"

func lastStoneWeight(stones []int) int {
	if len(stones) == 0 {
		return 0
	} else if len(stones) == 1 {
		return stones[0]
	}
	idx1, idx2 := 0, 0
	stone1, stone2 := -1<<31, -1<<31

	for idx := range stones {
		if stone1 < stones[idx] {
			idx1 = idx
			stone1 = stones[idx]
		}
	}
	for idx := range stones {
		if stone2 < stones[idx] && idx != idx1 {
			idx2 = idx
			stone2 = stones[idx]
		}
	}
	if stone1 == stone2 {
		left := deleteElemInArray(stones, idx1)
		right := deleteElemInArray(left, idx2-1)
		stones = right
	} else if stone1 > stone2 {
		stones[idx1] = stone1 - stone2
		stones = deleteElemInArray(stones, idx2)
	} else {
		stones[idx2] = stone2 - stone1
		stones = deleteElemInArray(stones, idx1)
	}
	return lastStoneWeight(stones)
}

func deleteElemInArray(arr []int, idx int) []int {
	return append(arr[:idx], arr[idx+1:]...)
}

// ---------------------------------------------------

func lastStoneWeightSort(stones []int) int {
	sort.Ints(stones)

	if len(stones) == 0 {
		return 0
	} else if len(stones) == 1 {
		return stones[0]
	}
	stone1 := stones[len(stones)-1]
	stone2 := stones[len(stones)-2]

	if stone1 == stone2 {
		return lastStoneWeight(stones[:len(stones)-2])
	} else {
		if stone1 > stone2 {
			stones[len(stones)-2] = stone1 - stone2
		} else {
			stones[len(stones)-2] = stone2 - stone1
		}
		return lastStoneWeight(stones[:len(stones)-1])
	}
}
