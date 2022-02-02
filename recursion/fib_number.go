package recursion

func GetNthFib(n int) int {
	f1, f2 := 0, 1
	for i := 0; i < n; i++ {
		f1, f2 = f2, f1+f2
	}
	return f1
}
