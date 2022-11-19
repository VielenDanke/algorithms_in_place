package golang_solutions

func addBinary(a string, b string) string {
	i, j, carry := len(a)-1, len(b)-1, 0
	result := ""

	for i >= 0 || j >= 0 || carry > 0 {
		if i >= 0 {
			carry += int(a[i] - '0')
			i--
		}
		if j >= 0 {
			carry += int(b[j] - '0')
			j--
		}
		if carry%2 == 0 {
			result = "0" + result
		} else {
			result = "1" + result
		}
		carry /= 2
	}
	return result
}
