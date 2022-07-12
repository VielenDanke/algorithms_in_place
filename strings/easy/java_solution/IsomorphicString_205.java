package strings.easy.java_solution;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString_205 {

    private static class SolutionMap {

        public boolean isIsomorphic(String s, String t) {
            int N = s.length();

            if (N != t.length()) return false;

            return findInString(s, t) && findInString(t, s);
        }

        private boolean findInString(String s, String t) {
            int N = s.length();

            Map<Character, Character> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                if (!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                } else {
                    if (map.get(s.charAt(i)) != t.charAt(i)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static class SolutionBuilder {

        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) return false;
            return transformString(s).equals(transformString(t));
        }

        private String transformString(String s) {
            int N = s.length();

            Map<Character, Integer> indexMapping = new HashMap<>();
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < N; i++) {
                char current = s.charAt(i);

                if (!indexMapping.containsKey(current)) {
                    indexMapping.put(current, i);
                }
                builder.append(indexMapping.get(current));
                builder.append(" ");
            }
            return builder.toString();
        }
    }
}
