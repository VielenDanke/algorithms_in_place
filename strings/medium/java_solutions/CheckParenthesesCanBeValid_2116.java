package strings.medium.java_solutions;

import java.util.Stack;

public class CheckParenthesesCanBeValid_2116 {

    public boolean canBeValid(String s, String locked) {
        return s.length() % 2 == 0 && validate(s, locked, '(') && validate(s, locked, ')');
    }

    private boolean validate(String s, String locked, char symbol) {
        int block = 0, free = 0, N = s.length();
        int start = symbol == '(' ? 0 : N - 1;
        int incr = symbol == '(' ? 1 : -1;
        for (int i = start; i >= -0 && i < N && block + free >= 0; i += incr) {
            if (locked.charAt(i) == '1') {
                block += s.charAt(i) == symbol ? 1 : -1;
            } else {
                free++;
            }
        }
        return Math.abs(block) <= free;
    }

    // -----------------------------------------------------------------------------------------------
    // Time Limit Exceeded

    public boolean canBeValidBacktrack(String s, String locked) {
        var stack = new Stack<Character>();
        return backtrack(stack, 0, s, locked);
    }

    private boolean backtrack(Stack<Character> stack, int nextIdx, String s, String locked) {
        if (nextIdx == s.length()) {
            return stack.isEmpty();
        }
        char nextChar = s.charAt(nextIdx);
        if (locked.charAt(nextIdx) == '0') {
            if (stack.isEmpty()) {
                stack.add('(');
                return backtrack(stack, nextIdx + 1, s, locked);
            }
            Character pop = stack.pop();
            if (backtrack(stack, nextIdx + 1, s, locked)) {
                return true;
            }
            stack.add(pop);
            stack.add('(');
        } else {
            if (nextChar == '(') {
                stack.add('(');
            } else if (nextChar == ')' && stack.isEmpty()) {
                return false;
            } else if (nextChar == ')') {
                stack.pop();
            }
        }
        return backtrack(stack, nextIdx + 1, s, locked);
    }
}
