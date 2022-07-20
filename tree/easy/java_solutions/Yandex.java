package tree.easy.java_solutions;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Yandex {

    private static class ComplexArray {


    }

    private static int wordLength;
    private static int numberOfPairs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        wordLength = scanner.nextInt();
        numberOfPairs = scanner.nextInt();

        List<List<String>> pairs = new ArrayList<>();

        for (int i = 0; i < numberOfPairs; i++) {
            String left = scanner.next();
            String right = scanner.next();
            if (left.length() == wordLength && right.length() == wordLength) {
                pairs.add(new ArrayList<>() {{
                    add(left);
                    add(right);
                }});
            }
        }
        hamming(pairs).forEach(System.out::println);
    }

    private static List<String> hamming(List<List<String>> pairs) {
        List<String> result = new ArrayList<>();

        pairs.forEach(pair -> findForPair(result, pair.get(0), pair.get(1)));

        return result;
    }

    private static void findForPair(List<String> result, String left, String right) {
        Map<String, Integer> store = new HashMap<>();

        backtrack(store, "", left, right);

        String minStr = "";
        int minDiff = 1 << 30;

        for (Map.Entry<String, Integer> entry : store.entrySet()) {
            if (minDiff > entry.getValue()) {
                minStr = entry.getKey();
                minDiff = entry.getValue();
            }
        }
        result.add(minStr);
    }

    private static void backtrack(Map<String, Integer> result, String temp, String left, String right) {
        if (temp.length() == wordLength) {
            result.put(temp, Math.max(calculateHamming(temp, left), calculateHamming(temp, right)));
            return;
        }
        for (int i = 0; i <= 1; i++) {
            backtrack(result, temp + i, left, right);
        }
    }

    private static int calculateHamming(String temp, String str) {
        int sum = 0;
        for (int i = 0; i < wordLength; i++) {
            if (temp.charAt(i) != str.charAt(i)) {
                sum++;
            }
        }
        return sum;
    }
}
