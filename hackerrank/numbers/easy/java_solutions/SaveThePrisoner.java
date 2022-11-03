package hackerrank.numbers.easy.java_solutions;

public class SaveThePrisoner {

    // https://www.hackerrank.com/challenges/save-the-prisoner/problem

    static class Solution {
        public static int saveThePrisoner(int n, int m, int s) {
            return ((s - 1 + m - 1) % n) + 1;
        }
    }
}
