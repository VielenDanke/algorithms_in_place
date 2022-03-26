package javasolutions.string.easy;

public class AddStrings {

    public static String addStrings(String num1, String num2) {
        if (num1.length() != num2.length()) {
            if (num1.length() < num2.length()) {
                StringBuilder num1Builder = new StringBuilder(num1);
                while (num1Builder.length() < num2.length()) {
                    num1Builder.insert(0, "0");
                }
                num1 = num1Builder.toString();
            } else {
                StringBuilder num1Builder = new StringBuilder(num2);
                while (num1Builder.length() < num1.length()) {
                    num1Builder.insert(0, "0");
                }
                num2 = num1Builder.toString();
            }
        }
        StringBuilder resultAnswer = new StringBuilder();
        int currentIdx = num1.length() - 1;
        int remainder = 0;
        while (currentIdx >= 0) {
            char first = num1.charAt(currentIdx);
            char second = num2.charAt(currentIdx);

            int currentResult = (first - '0') + (second - '0');

            if (currentIdx != 0) {
                if (remainder != 0) {
                    currentResult += remainder;
                }
                if (currentResult > 9) {
                    remainder = currentResult / 10;
                    currentResult = currentResult % 10;
                } else {
                    remainder = 0;
                }
                resultAnswer.insert(0, currentResult);
            } else {
                currentResult += remainder;
                resultAnswer.insert(0, currentResult);
            }
            currentIdx--;
        }
        return resultAnswer.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("0", "11"));
    }
}
