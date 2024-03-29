package leetcode.strings.medium.java_solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams_438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int window = p.length();
        for (int i = 0; i + window <= s.length(); i++) {
            if (isAnagram(s.substring(i, i + window).toCharArray(), p.toCharArray())) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isAnagram(char[] left, char[] right) {
        int[] arr = new int[26];

        for (char c : left) {
            arr[c-'a']++;
        }
        for (char c : right) {
            arr[c-'a']--;
        }
        for (int j : arr) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
    // ------------------------------------------------------------------------------

    public List<Integer> findAnagramsBetter(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int m = p.length(), n = s.length();
        if (m > n) {
            return list;
        }
        int[] left = new int[26];
        int[] right = new int[26];
        for (int i = 0; i < m; i++) {
            left[s.charAt(i) - 'a']++;
            right[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(left, right)) {
            list.add(0);
        }
        for (int i = m; i < n; i++) {
            left[s.charAt(i)-'a']++;
            left[s.charAt(i- m) - 'a']--;
            if (Arrays.equals(left, right)) {
                list.add(i- m + 1);
            }
        }
        return list;
    }
}
