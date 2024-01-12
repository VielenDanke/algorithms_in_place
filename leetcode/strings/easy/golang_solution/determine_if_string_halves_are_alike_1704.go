package golang_solution

var alph []int
var vowels = []rune{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}

func init() {
	alph = make([]int, 128)

	for _, v := range vowels {
		alph[v-'A']++
	}
}

func halvesAreAlike(s string) bool {
	leftCounter, rightCounter := 0, 0
	for i, v := range s {
		if i < len(s)/2 && alph[v-'A'] > 0 {
			leftCounter++
		} else if alph[v-'A'] > 0 {
			rightCounter++
		}
	}
	return leftCounter == rightCounter
}
