package javasolutions.string.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ScoreOfParentheses {

    static class Node {
        int result = 0;
        List<Node> children = new ArrayList<>();

        public Node(int result) {
            this.result = result;
        }
    }

    public static int scoreOfParenthesesBetter(String s) {
        Stack<Integer> st = new Stack<>();
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(score);
                score = 0;
            } else {
                score = st.pop() + Math.max(2 * score, 1);
            }
        }
        return score;
    }

    public static int scoreOfParentheses(String s) {
        // track of internal balanced and one after other
        if (s == null || s.isBlank()) {
            return 0;
        }
        Stack<Node> st = new Stack<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.add(new Node(1));
            } else {
                Node pop = st.pop();
                if (st.size() != 0) {
                    if (pop.children.size() != 0) {
                        int temp = 0;
                        for (Node n : pop.children) {
                            temp += n.result;
                        }
                        st.peek().children.add(new Node(2 * temp));
                    } else {
                        st.peek().children.add(pop);
                    }
                } else {
                    if (pop.children.size() == 0) {
                        result++;
                    } else {
                        int temp = 0;
                        for (Node n : pop.children) {
                            temp += n.result;
                        }
                        result += 2 * temp;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.printf("Result: %d\n", ScoreOfParentheses.scoreOfParenthesesBetter("()()"));
    }
}
