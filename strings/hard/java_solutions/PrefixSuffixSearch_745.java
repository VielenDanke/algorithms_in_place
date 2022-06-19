package strings.hard.java_solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrefixSuffixSearch_745 {

    public static class WordFilter {
        private final Map<String, Map<String, Integer>> map = new HashMap<>();

        public WordFilter(String[] arr) {
            for (int i = 0; i < arr.length; i++) {
                String s = arr[i];
                int len = s.length();

                for (int j = 0; j < len; j++) {
                    String t = s.substring(0, j + 1);
                    Map<String, Integer> temp = new HashMap<>();
                    map.putIfAbsent(t, temp);
                    for (int k = 0; k < len; k++) {
                        temp.put(s.substring(k, len), i);
                    }
                }
            }
        }

        public int f(String prefix, String suffix) {
            int max = -1;
            if (map.containsKey(prefix)) {
                Map<String, Integer> hm = map.get(prefix);
                if (hm.containsKey(suffix)) {
                    max = Math.max(max, hm.get(suffix));
                }
            }
            return max;
        }

        public static void main(String[] args) {
            int f = new WordFilter(new String[]{"apple"}).f("a", "e");
            System.out.println(f);
        }
    }

    // -------------------------------------------------------------------------------------------------------------------

    private static class Trie {
        Map<Integer, String[]> prefixSuffix = new HashMap<>();

        Trie(String str) {
            for (int i = 0; i < str.length(); i++) {
                prefixSuffix.put(i + 1, new String[]{str.substring(0, i + 1), str.substring(str.length() - i - 1)});
            }
        }
    }

    private final Trie[] tries;
    private final int N;

    public PrefixSuffixSearch_745(String[] words) {
        this.N = words.length;
        this.tries = new Trie[words.length];
        for (int i = 0; i < words.length; i++) tries[i] = new Trie(words[i]);
    }

    public int f(String prefix, String suffix) {
        int prefixSize = prefix.length(), suffixSize = suffix.length();
        int answer = -1;
        for (int i = 0; i < N; i++) {
            Trie trie = tries[i];
            Map<Integer, String[]> current = trie.prefixSuffix;
            if (!current.containsKey(prefixSize) || !current.containsKey(suffixSize)) {
                continue;
            }
            if (current.get(prefixSize)[0].equals(prefix) && current.get(suffixSize)[1].equals(suffix)) {
                answer = i;
            }
        }
        return answer;
    }
}
