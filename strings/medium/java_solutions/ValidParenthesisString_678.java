package strings.medium.java_solutions;

public class ValidParenthesisString_678 {

    public boolean checkValidString(String s) {
        int lower = 0, higher = 0;
        for (char c : s.toCharArray()) {
            lower += c == '(' ? 1 : -1;
            higher += c != ')' ? 1 : -1;
            if (higher < 0) {
                break;
            }
            lower = Math.max(lower, 0);
        }
        return lower == 0;
    }
}
