package javasolutions.string.medium;

import java.util.Stack;

public class MinimumRevokeToMakeValidParentheses {

    public static String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(c);
                result.append(c);
            } else if (c == ')') {
                if (stack.size() == 0) {
                    continue;
                }
                stack.pop();
                result.append(c);
            } else {
                result.append(c);
            }
        }
        int size = stack.size();

        if (size > 0) {
            stack = new Stack<>();
            for (int i = result.length() - 1; i >= 0; i--) {
                if (size <= 0) {
                    break;
                }
                char c = result.charAt(i);
                if (c == '(' && stack.isEmpty()) {
                    result.deleteCharAt(i);
                    size--;
                } else if (c == '(') {
                    stack.pop();
                } else if (c == ')') {
                    stack.add(c);
                }
            }
        }
        return result.toString();
    }

    public String minRemoveToMakeValidTwo(String s) {
        Stack<Integer> st = new Stack<>();

        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                st.push(i);
            } else if (ch[i] == ')') {
                if (st.isEmpty()) {
                    ch[i] = '#';
                } else {
                    st.pop();
                }
            }
        }
        while (!st.isEmpty()) {
            ch[st.pop()] = '#';
        }
        StringBuilder sb = new StringBuilder();

        for (char c : ch) {
            if (c != '#') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = MinimumRevokeToMakeValidParentheses.minRemoveToMakeValid("())()(((");

        System.out.println(res);
    }
}
