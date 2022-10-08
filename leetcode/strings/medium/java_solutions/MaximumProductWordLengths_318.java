package leetcode.strings.medium.java_solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static leetcode.structures.java_solutions.PrefixTrie_208.*;

public class MaximumProductWordLengths_318 {

    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        return maxProduct;
    }

    // -------------------------------------------------------------------------------

    public int maxProductSet(String[] words) {
        int N = words.length, max = 0;
        List<Set<Character>> l = new ArrayList<>();

        for (String word : words) {
            Set<Character> set = new HashSet<>();
            for (char c : word.toCharArray()) {
                set.add(c);
            }
            l.add(set);
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                var iSet = l.get(i);
                var jSet = l.get(j);
                var isPower = true;
                for (Character c : iSet) {
                    if (jSet.contains(c)) {
                        isPower = false;
                        break;
                    }
                }
                if (isPower) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    // ---------------------------------------------------------------------------------

    public int maxProductSuffixTrie(String[] words) {
        List<SuffixTrie> tries = new ArrayList<>();
        int maxProduct = 0;

        for (String word : words) {
            tries.add(new SuffixTrie(word));
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!tries.get(i).hasIntersections(words[j])) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maxProduct;
    }
}
