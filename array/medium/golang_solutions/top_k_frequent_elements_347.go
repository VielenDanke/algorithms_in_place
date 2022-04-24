package golang_solutions

import "sort"

func TopKFrequent(nums []int, k int) []int {
	mostFrequent := make(map[int]int)
	result := make([]int, 0)

	for _, v := range nums {
		mostFrequent[v]++
	}
	for i := 0; i < k; i++ {
		mostFrequentNum := 0
		mostFrequentIdx := 0
		for j := 0; j < len(nums); j++ {
			if mostFrequentNum < mostFrequent[nums[j]] {
				mostFrequentNum = mostFrequent[nums[j]]
				mostFrequentIdx = j
			}
		}
		delete(mostFrequent, nums[mostFrequentIdx])
		result = append(result, nums[mostFrequentIdx])
	}
	return result
}

func TopKFrequentFaster(nums []int, k int) []int {
	frequent := make(map[int]int)

	for _, v := range nums {
		frequent[v]++
	}
	mostFrequent := make(map[int]map[int]interface{})
	mostFrequentArray := make([]int, 0)

	for i, v := range frequent {
		if _, ok := mostFrequent[v]; !ok {
			mostFrequent[v] = make(map[int]interface{})
		}
		mostFrequent[v][i] = nil
		mostFrequentArray = append(mostFrequentArray, v)
	}
	sort.Ints(mostFrequentArray)

	result := make([]int, 0)

	for i := len(mostFrequentArray) - 1; i >= 0 && k != 0; i-- {
		mostFrequentAmount := mostFrequentArray[i]
		mostFrequentNumbers := mostFrequent[mostFrequentAmount]
		for kFrequent := range mostFrequentNumbers {
			result = append(result, kFrequent)
			k -= 1
			if k == 0 {
				break
			}
		}
		delete(mostFrequent, mostFrequentAmount)
	}
	return result
}

// From discussion
func topKFrequentFasterArray(nums []int, k int) []int {
	mapper := make(map[int]int)
	for _, v := range nums {
		mapper[v] += 1
	}
	var num []int
	nm := make(map[int][]int)
	for i, v := range mapper {
		nm[v] = append(nm[v], i)
		num = append(num, v)
	}
	var ans []int
	sort.Ints(num)
	for i := 0; i < k; i++ {
		j := len(num) - 1 - i
		ans = append(ans, nm[num[j]][len(nm[num[j]])-1])
		nm[num[j]] = nm[num[j]][:len(nm[num[j]])-1]
	}
	return ans
}
