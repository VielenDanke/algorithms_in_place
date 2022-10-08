package leetcode.strings.hard.java_solutions;

public class InterweavingStrings_Algo {

    /*
    def recursive_find(self, left: int, right: int, s1: str, s2: str, s3: str, memo: list[list[int]]):
        k = left + right
        if memo[left][right] != -1 << 30:
            return memo[left][right]
        if k == len(s3):
            return True
        if left < len(s1) and s1[left] == s3[k]:
            is_interleave = self.recursive_find(left + 1, right, s1, s2, s3, memo)
            memo[left][right] = is_interleave
            if is_interleave:
                return True
        if right < len(s2) and s2[right] == s3[k]:
            is_interleave = self.recursive_find(left, right + 1, s1, s2, s3, memo)
            memo[left][right] = is_interleave
            if is_interleave:
                return True
        memo[left][right] = False
        return False


    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s1) + len(s2) != len(s3):
            return False
        left, right, max_len = 0, 0, max(len(s1), len(s2))

        memo = [[-1 << 30] * (max_len + 1) for i in range(max_len + 1)]

        return self.recursive_find(left, right, s1, s2, s3, memo)
     */

    public static boolean interweavingStrings(String one, String two, String three) {
        // Write your code here.
        if (one.length() + two.length() != three.length()) {
            return false;
        }
        Boolean[][] cache = new Boolean[one.length() + 1][two.length() + 1];
        return areInterweaving(one, two, three, 0, 0, cache);
    }

    private static boolean areInterweaving(String one, String two, String three, int i, int j, Boolean[][] cache) {
        Boolean cachedInterweaving = cache[i][j];
        if (cachedInterweaving != null) {
            return cachedInterweaving;
        }
        int k = i + j;

        if (k == three.length()) {
            return true;
        }
        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            boolean isInterweaving = areInterweaving(one, two, three, i + 1, j, cache);
            cache[i][j] = isInterweaving;
            if (isInterweaving) {
                return true;
            }
        }
        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            boolean isInterweaving = areInterweaving(one, two, three, i, j + 1, cache);
            cache[i][j] = isInterweaving;
            if (isInterweaving) {
                return true;
            }
        }
        cache[i][j] = false;
        return false;
    }
}
