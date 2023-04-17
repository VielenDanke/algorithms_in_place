package golang_solutions

func HackerrankInString(s string) string {
	// Write your code here
	word := "hackerrank"

	if len(word) > len(s) {
		return "NO"
	}
	pointer := 0

	for i := 0; i < len(s) && pointer < len(word); i++ {
		if s[i] == word[pointer] {
			pointer++
		}
	}
	if pointer >= len(word) {
		return "YES"
	}
	return "NO"
}
