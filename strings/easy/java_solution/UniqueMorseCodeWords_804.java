package strings.easy.java_solution;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords_804 {

    private static class Solution {

        public int uniqueMorseRepresentations(String[] words) {
            String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            Set<String> set = new HashSet<>();
            for (String word : words) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    builder.append(morse[word.charAt(i) - 'a']);
                }
                set.add(builder.toString());
            }
            return set.size();
        }
    }
}
