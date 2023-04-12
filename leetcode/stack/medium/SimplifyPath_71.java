package leetcode.stack.medium;

import java.util.Stack;

public class SimplifyPath_71 {

    static class SolutionStack {

        public String simplifyPath(String path) {
            String[] paths = path.split("/");

            Stack<String> stack = new Stack<>();

            for (String p : paths) {
                if (p != null && !p.equals(".") && !p.isBlank()) {
                    if (p.equals("..")) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    } else {
                        stack.push(p);
                    }
                }
            }
            return "/" + String.join("/", stack);
        }
    }

    static class SolutionStackFaster {

        private Stack<String> stack;

        public String simplifyPath(String path) {
            this.stack = new Stack<>();

            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == '/') {
                    i = addPath(path, i);
                }
            }
            if (stack.isEmpty()) return "/";
            StringBuilder result = new StringBuilder();
            for (String p : stack) {
                result.append("/");
                result.append(p);
            }
            return result.toString();
        }

        private int addPath(String path, int idx) {
            while (idx < path.length() && path.charAt(idx) == '/') {
                idx++;
            }
            int start = idx;

            while (idx < path.length() && path.charAt(idx) != '/') {
                idx++;
            }
            int end = idx;

            String subPath = path.substring(start, end);

            if (subPath.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!subPath.equals(".") && !subPath.isBlank() && !subPath.equals("..")) {
                stack.push(subPath);
            }
            return idx - 1;
        }
    }
}
