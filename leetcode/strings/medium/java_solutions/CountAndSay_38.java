package leetcode.strings.medium.java_solutions;

public class CountAndSay_38 {

    public String countAndSay(int n) {
        String say = "1";

        for (int i = 1; i < n; i++) {
            say = count(say);
        }
        return say;
    }

    private String count(String say) {
        StringBuilder builder = new StringBuilder();
        char c = say.charAt(0);
        int count = 1;

        for (int i = 1; i < say.length(); i++) {
            if (say.charAt(i) == c) {
                count++;
            } else {
                builder.append(count);
                builder.append(c);
                c = say.charAt(i);
                count = 1;
            }
        }
        builder.append(count);
        builder.append(c);
        return builder.toString();
    }
}
