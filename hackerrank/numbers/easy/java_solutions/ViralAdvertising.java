package hackerrank.numbers.easy.java_solutions;

public class ViralAdvertising {

    // https://www.hackerrank.com/challenges/strange-advertising

    public static int viralAdvertising(int n) {
        int result = 0;
        for (int people = 5, liked, i = 0; i < n; i++) {
            liked = people / 2;
            people = liked * 3;
            result += liked;
        }
        return result;
    }
}
