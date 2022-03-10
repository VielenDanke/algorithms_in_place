package javasolutions.dynamic;

import java.util.Arrays;

public class LevenshteinDistance {

    public static int levenshteinDistance2(String str1, String str2) {
        if (str1.length() == 0 && str2.length() != 0) {
            return str2.length();
        }
        int idx = 0;
        int replaceAmount = 0;
        while (idx < str1.length() && idx < str2.length()) {
            if (str1.charAt(idx) != str2.charAt(idx)) {
                str1 = renewString(str1, str2, str2.charAt(idx), idx);
                idx = 0;
                replaceAmount++;
                continue;
            }
            idx++;
        }
        while (idx < str2.length()) {
            replaceAmount++;
            idx++;
        }
        return replaceAmount;
    }

    public static String renewString(String str1, String str2, char replace, int idx) {
        StringBuilder builder = new StringBuilder();
        if (idx == 0 && (str1.length() == str2.length())) {
            char[] array = str1.toCharArray();
            array[0] = replace;
            builder.append(array);
        } else if (idx == 0) {
            builder.append(replace);
            builder.append(str1);
        } else if (idx == str1.length() - 1) {
            char[] array = str1.toCharArray();
            array[array.length - 1] = replace;
            builder.append(array);
        } else {
            if (idx + 1 < str2.length() && str1.charAt(idx) != str2.charAt(idx + 1)) {
                builder.append(str1);
                builder.replace(idx, idx + 1, String.valueOf(replace));
            } else {
                String first = str1.substring(0, idx);
                String last = str1.substring(idx);
                builder.append(first);
                builder.append(replace);
                builder.append(last);
            }
        }
        return builder.toString();
    }

    // ######################################################################################################

    // Time O(nm) | Space O(nm)
    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        int[][] edits = new int[str2.length() + 1][str1.length() + 1];
        for (int i = 0; i < str2.length() + 1; i++) {
            for (int j = 0; j < str1.length() + 1; j++) {
                edits[i][j] = j;
            }
            edits[i][0] = i;
        }
        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = 1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i - 1][j], edits[i][j - 1]));
                }
            }
        }
        return edits[str2.length()][str1.length()];
    }

    // ######################################################################################################

    public static int levenshteinDistance3(String x, String y) {
        if (x.isEmpty()) {
            return y.length();
        }
        if (y.isEmpty()) {
            return x.length();
        }
        int substitution = levenshteinDistance(x.substring(1), y.substring(1))
                + costOfSubstitution(x.charAt(0), y.charAt(0));
        int insertion = levenshteinDistance(x, y.substring(1)) + 1;
        int deletion = levenshteinDistance(x.substring(1), y) + 1;

        return min(substitution, insertion, deletion);
    }

    private static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    private static int min(int... numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        System.out.printf("Result: %d\n", LevenshteinDistance.levenshteinDistance3("biting", "mitten"));
    }
}
