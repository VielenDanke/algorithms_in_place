package strings.easy.java_solution;

public class BackspaceStringCompare_844 {

    public boolean backspaceCompare(String s, String t) {
        return findResultString(s).equals(findResultString(t));
    }

    private String findResultString(String s) {
        StringBuilder builder = new StringBuilder();

        int pointer = 0;

        while (pointer < s.length()) {
            char ch = s.charAt(pointer);
            if (ch == '#') {
                if (!builder.isEmpty()) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else {
                builder.append(ch);
            }
            pointer++;
        }
        return builder.toString();
    }
}
