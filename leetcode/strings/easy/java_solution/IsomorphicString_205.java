package leetcode.strings.easy.java_solution;

import java.util.HashMap;
import java.util.Map;

/*
Rust solution:

use std::collections::HashMap;

struct Solution {}

impl Solution {
    pub fn is_isomorphic(s: String, t: String) -> bool {
        if s.len() != t.len() {
            false
        } else {
            Solution::check(&s, &t) && Solution::check(&t, &s)
        }
    }

    fn check(s: &String, t: &String) -> bool {
        let mut map = HashMap::new();
        let (s_bytes, t_bytes) = (s.as_bytes(), t.as_bytes());

        for i in 0..s.len() {
            let s_current = s_bytes[i];
            let t_current = t_bytes[i];
            if let Some(old_value) = map.insert(s_current, t_current) {
                if old_value != t_current {
                    return false;
                }
            }
        }
        true
    }
}

 */

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
