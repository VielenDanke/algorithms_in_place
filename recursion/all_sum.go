package recursion

type SpecialArray []interface{}

func ProductSum(array []interface{}) (sum int) {
	// Write your code here.
	// in the cycle call recursive function
	// create depths variable
	// if passed interface is an int - return * depth
	return calculateDepthSum(array, 1)
}

func calculateDepthSum(elems SpecialArray, multiplier int) int {
	sum := 0
	for _, v := range elems {
		cast, ok := v.(SpecialArray)
		if ok {
			sum += calculateDepthSum(cast, multiplier+1)
		} else if cast, ok := v.(int); ok {
			sum += cast
		}
	}
	return sum * multiplier
}
