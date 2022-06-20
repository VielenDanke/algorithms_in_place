package strings.medium.java_solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingWords_820 {

    public int minimumLengthEncodingSet(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                String current = word.substring(i);
                if (set.contains(current)) {
                    set.remove(current);
                }
            }
        }
        return set.stream().mapToInt(str -> str.length() + 1).sum();
    }

    // -------------------------------------------------------------------------------------

    public int minimumLengthEncodingSort(String[] words) {
        int N = words.length;

        StringBuilder result = new StringBuilder();

        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = N - 1; i >= 0; i--) {
            String currentWord = words[i] + "#";
            if (result.indexOf(currentWord) == -1) result.append(currentWord);
        }
        return result.length();
    }

    // -------------------------------------------------------------------------------------

    public int minimumLengthEncoding(String[] words) {
        int N = words.length;

        for (int i = 0; i < N; i++) {
            words[i] = words[i] + "#";
        }
        boolean[] absorbed = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!absorbed[i]) {
                for (int j = 0; j < N; j++) {
                    if (i != j && !absorbed[j]) {
                        if (words[i].contains(words[j])) {
                            absorbed[j] = true;
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (!absorbed[i]) result += words[i].length();
        }
        return result;
    }
}
