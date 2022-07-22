package strings.medium.java_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberMatchingSubsequences_792 {

    private static class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            int result = 0;
            Map<String, Boolean> subsequenceMap = new HashMap<>();
            for (String word : words) {
                if (subsequenceMap.containsKey(word)) {
                    if (subsequenceMap.get(word)) {
                        result++;
                    }
                } else {
                    if (isSubsequence(s, word)) {
                        result++;
                        subsequenceMap.put(word, true);
                    } else {
                        subsequenceMap.put(word, false);
                    }
                }

            }
            return result;
        }

        private boolean isSubsequence(String s, String sub) {
            int left = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == sub.charAt(left)) {
                    left++;
                    if (left == sub.length()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private static class SolutionFaster {
        public int numMatchingSubseq(String s, String[] words) {
            Map<Character, List<StringBuilder>> buildersMap = new HashMap<>();

            for (String word : words) {
                if (buildersMap.containsKey(word.charAt(0))) {
                    buildersMap.get(word.charAt(0)).add(new StringBuilder(word));
                } else {
                    buildersMap.put(word.charAt(0), new ArrayList<>() {{
                        add(new StringBuilder(word));
                    }});
                }
            }
            int result = 0;
            for (char c : s.toCharArray()) {
                List<StringBuilder> stringBuilders = buildersMap.get(c);

                if (stringBuilders == null) continue;

                buildersMap.put(c, new ArrayList<>());

                for (StringBuilder b : stringBuilders) {
                    b.deleteCharAt(0);
                    if (b.length() != 0) {
                        if (buildersMap.containsKey(b.charAt(0))) {
                            buildersMap.get(b.charAt(0)).add(b);
                        } else {
                            buildersMap.put(b.charAt(0), new ArrayList<>(){{ add(new StringBuilder(b)); }});
                        }
                    } else {
                        result++;
                    }
                }
            }
            return result;
        }
    }

    private static class SolutionWithArray {
        public int numMatchingSubseq(String s, String[] words) {
            int answer = 0;
            List<StringBuilder>[] waiting = new List[128];

            for (int c = 0; c <= 'z'; c++) {
                waiting[c] = new ArrayList<>();
            }
            for (String word : words) {
                waiting[word.charAt(0)].add(new StringBuilder(word));
            }
            for (char c : s.toCharArray()) {
                List<StringBuilder> stringBuilders = waiting[c];

                waiting[c] = new ArrayList<>();

                for (StringBuilder builder : stringBuilders) {
                    builder.deleteCharAt(0);

                    if (builder.length() != 0) {
                        waiting[builder.charAt(0)].add(builder);
                    } else {
                        answer++;
                    }
                }
            }
            return answer;
        }
    }
}
