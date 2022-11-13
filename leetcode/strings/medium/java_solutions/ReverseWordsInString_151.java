package leetcode.strings.medium.java_solutions;

import java.util.LinkedList;
import java.util.TreeMap;

public class ReverseWordsInString_151 {

    static class SolutionTreeMap {

        public String reverseWords(String s) {
            int order = 1;
            TreeMap<Integer, String> map = new TreeMap<>();

            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetterOrDigit(s.charAt(i))) {
                    StringBuilder builder = new StringBuilder();
                    while (i < s.length() && Character.isLetterOrDigit(s.charAt(i))) {
                        builder.append(s.charAt(i++));
                    }
                    map.put(order++, builder.toString());
                }
            }
            StringBuilder result = new StringBuilder();
            while (!map.isEmpty()) {
                result.append(map.pollLastEntry().getValue());
                if (!map.isEmpty()) {
                    result.append(" ");
                }
            }
            return result.toString();
        }
    }

    static class SolutionLinkedList {
        public String reverseWords(String s) {
            LinkedList<String> list = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetterOrDigit(s.charAt(i))) {
                    StringBuilder builder = new StringBuilder();
                    while (i < s.length() && Character.isLetterOrDigit(s.charAt(i))) {
                        builder.append(s.charAt(i++));
                    }
                    list.add(builder.toString());
                }
            }
            StringBuilder result = new StringBuilder();
            while (!list.isEmpty()) {
                result.append(list.removeLast());
                if (!list.isEmpty()) {
                    result.append(" ");
                }
            }
            return result.toString();
        }
    }
}
