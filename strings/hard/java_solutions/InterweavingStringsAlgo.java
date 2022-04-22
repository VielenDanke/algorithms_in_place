package strings.hard.java_solutions;

public class InterweavingStringsAlgo {

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
