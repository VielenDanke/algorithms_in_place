package backtracking_recursion.java_solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationsPhoneNumber_17 {

    private static final String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /*
    "23" input
    1. append 'a'
    2. append all letters to 'a' from idx 3 - "def"
    3. return from recursion - start iteration from b
    4. repeat all process again
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        combinationHelper("", digits, 0, result);
        return result;
    }

    public void combinationHelper(String prefix, String digits, int index, List<String> result) {
        if (index >= digits.length()) {
            result.add(prefix);
            return;
        }
        // find idx in phone array
        int idx = digits.charAt(index) - '0';
        // take letters from an array
        String letters = phone[idx];
        for (int i = 0; i < letters.length(); i++) {
            // append first letter - move index to next
            combinationHelper(prefix + letters.charAt(i), digits, index + 1, result);
        }
    }

    // ---------------------------------------------------------------------------------------------------------

    /*
    "23" input
    1. add all letters from 2 - "abc"
    2. remove 'a' and add all letters from 3 - "def"
    3. remove 'b' and add all letters from 3 - "def"
    4. remove 'c' and add all letters from 3 - "def"
     */
    public List<String> letterCombinationsQueue(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek() != null && ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : phone[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }
}
