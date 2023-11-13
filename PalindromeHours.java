import java.util.Scanner;

public class PalindromeHours {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nextHours = sc.next();
        int n = Integer.parseInt(nextHours);
        String toMaxN = String.valueOf(n - 1);
        String nextMinutes = sc.next();
        int m = Integer.parseInt(nextMinutes);
        String toMaxM = String.valueOf(m - 1);

        int palindromes = 0;

        int maxSize = Math.max(toMaxN.length(), toMaxM.length());

        String format = "%0" + maxSize + "d";

        for (int currentMinutes = 0; currentMinutes < m; currentMinutes++) {
            String right = String.format(format, currentMinutes);
            StringBuilder left = new StringBuilder(right).reverse();
            if (Integer.parseInt(left.toString()) < n) {
                palindromes++;
            }
        }
        System.out.println(palindromes);
    }

    private static boolean isPalindromeTime(int hour, int minute, int maxSize) {
        String format = "%0" + maxSize + "d:%0" + maxSize + "d";
        String timeStr = String.format(format, hour, minute);
        return timeStr.contentEquals(new StringBuilder(timeStr).reverse());
    }
}
