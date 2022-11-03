package hackerrank.numbers.easy.java_solutions;

public class CatAndMouse {

    // https://www.hackerrank.com/challenges/cats-and-a-mouse

    static class Solution {

        static String catAndMouse(int x, int y, int z) {
            if (Math.abs(y - z) < Math.abs(x - z)) {
                return "Cat B";
            } else if (Math.abs(y - z) > Math.abs(x - z)) {
                return "Cat A";
            } else {
                return "Mouse C";
            }
        }
    }
}
