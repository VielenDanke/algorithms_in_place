package leetcode.strings.medium.java_solutions;

public class ReverseWordInPlace {

    public static char[] reverseWords(char[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] != ' ') {
                i = reverse(input, i);
            }
        }
        return input;
    }

    private static int reverse(char[] input, int start) {
        int end = start;
        while (end < input.length && input[end] != ' ') {
            end++;
        }
        end--;
        while (start < end) {
            swap(input, start, end);
            start++;
            end--;
        }
        return end + 1;
    }

    private static void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
