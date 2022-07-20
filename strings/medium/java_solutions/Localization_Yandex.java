package strings.medium.java_solutions;

import java.util.*;

public class Localization_Yandex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> l = new ArrayList<>();

        int numOfStrings = sc.nextInt();

        for (int i = 0; i < numOfStrings; i++) {
            l.add(sc.next());
        }
        findForString(l).forEach(System.out::println);
    }

    public static List<String> findForString(List<String> l) {
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String s : l) {
            if (!findCorrect(result, set, s, 1, s.length() - 1)) {
                result.add(s);
            }
        }
        return result;
    }

    private static boolean findCorrect(List<String> result, Set<String> set, String s, int left, int right) {
        if (left >= right) {
            return false;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < left; i++) {
            builder.append(s.charAt(i));
        }
        builder.append((right - left));
        for (int i = s.length() - 1; i >= right; i--) {
            builder.append(s.charAt(i));
        }
        if (set.contains(builder.toString())) {
            return findCorrect(result, set, s, left + 1, right - 1);
        } else {
            String res = builder.toString();
            result.add(res);
            return set.add(res);
        }
    }
}
