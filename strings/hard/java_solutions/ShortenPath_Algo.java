package strings.hard.java_solutions;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortenPath_Algo {

    public static String shortenPath(String path) {
        // Write your code here;
        StringBuilder sb = new StringBuilder();
        for (char c : path.toCharArray()) {
            if ((sb.length() != 0 && sb.charAt(sb.length() - 1) == '/' && c == '/')) {
                continue;
            }
            sb.append(c);
        }
        String[] dirs = sb.toString().split("/");
        if (dirs.length == 0) {
            return "/";
        }
        boolean isRoot = false;
        Stack<String> stack = new Stack<>();

        if (dirs[0].isBlank()) {
            isRoot = true;
        }
        for (String dir : dirs) {
            if (dir.equals(".") || dir.isBlank()) {
                continue;
            } else if (dir.equals("..")) {
                if (stack.isEmpty()) {
                    stack.add(dir);
                } else {
                    if (stack.peek().equals("..")) {
                        stack.add(dir);
                    } else {
                        stack.pop();
                    }
                }
            } else {
                while (!stack.isEmpty() && isRoot && stack.peek().equals("..")) {
                    stack.pop();
                }
                stack.add(dir);
            }
        }
        if (isRoot && !stack.isEmpty() && stack.peek().equals("..")) {
            return "/";
        }
        String result = String.join("/", stack);
        return isRoot ? "/" + result : result;
    }

    // -----------------------------------------------------------------------------------------

    public static String shortenPathBetter(String path) {
        if (path == null || path.isBlank()) {
            return "";
        }
        boolean startsWithPath = path.charAt(0) == '/';
        String[] tokenList = path.split("/");
        Stack<String> stack = new Stack<>();
        if (startsWithPath) stack.add("");
        for (String token : tokenList) {
            if (token.equals("..")) {
                if (stack.isEmpty() || stack.peek().equals("..")) {
                    stack.add(token);
                } else if (!stack.peek().equals("")) {
                    stack.pop();
                }
            } else if (token.isBlank() || token.equals(".")) {
                continue;
            } else {
                stack.add(token);
            }
        }
        if (stack.size() == 1 && stack.peek().equals("")) return "/";
        return String.join("/", stack);
    }
}
