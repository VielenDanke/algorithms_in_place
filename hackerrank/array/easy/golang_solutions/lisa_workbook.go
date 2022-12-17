package golang_solutions

func Workbook(_ int32, k int32, arr []int32) int32 {
	pageCounter, result := int32(1), int32(0)
	for _, v := range arr {
		j := v
		counter := int32(0)

		for j > 0 {
			for i := int32(0); i < min(j, k); i++ {
				counter++
				if counter == pageCounter {
					result++
				}
			}
			pageCounter++
			j -= k
		}
	}
	return result
}
