package javasolutions.string.medium;

import java.util.LinkedList;

public class SimplifyPath {

    public String simplifyPath(String path) {
        var parts = path.split("/");
        var list = new LinkedList<String>();
        for (var part : parts) {
            if (part != null && !part.isEmpty() && !".".equals(part)) {
                if ("..".equals(part)) {
                    list.pollLast();
                } else {
                    list.add(part);
                }
            }
        }
        return "/" + String.join("/", list);
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/a//b////c/d//././/.."));
    }
}
