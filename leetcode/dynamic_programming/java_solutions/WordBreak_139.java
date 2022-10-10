package leetcode.dynamic_programming.java_solutions;

import java.util.*;

public class WordBreak_139 {

    static class SolutionDP {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];

            dp[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && dict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

    static class SolutionHashSet {

        public boolean wordBreak(String s, List<String> wordDict) {
            return backtrack(new HashSet<>(wordDict), s);
        }

        private boolean backtrack(Set<String> dictSet, String s) {
            if (s.length() == 0) {
                return true;
            }
            for (int i = 0; i <= s.length(); i++) {
                String subWord = s.substring(0, i);
                if (dictSet.contains(subWord)) {
                    if (backtrack(dictSet, s.substring(i))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static class SolutionBacktrackStringBuilder {

        public boolean wordBreak(String s, List<String> wordDict) {
            return backtrack(wordDict, new StringBuilder(), s);
        }

        private boolean backtrack(List<String> wordDict, StringBuilder temp, String s) {
            if (temp.length() == s.length()) {
                return temp.toString().equals(s);
            }
            for (int i = 0; i < wordDict.size(); i++) {
                String current = wordDict.get(i);
                if (temp.length() + current.length() <= s.length()) {
                    int size = temp.length();
                    temp.append(current);
                    if (backtrack(wordDict, temp, s)) {
                        return true;
                    }
                    temp.delete(size, temp.length());
                }
            }
            return false;
        }
    }
}
