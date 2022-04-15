package bit_manipulation

func hammingWeight(num uint32) int {
	var bitsNum uint32
	for num != 0 {
		bitsNum += num & 1
		num >>= 1
	}
	return int(bitsNum)
}
