package golang_solutions

/*
static class Solution {
        public static int saveThePrisoner(int n, int m, int s) {
            return ((s - 1 + m - 1) % n) + 1;
        }
    }
*/

func saveThePrisoner(n, m, s int) int {
	return ((s - 1 + m - 1) % n) + 1
}
