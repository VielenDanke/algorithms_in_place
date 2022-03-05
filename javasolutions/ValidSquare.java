package javasolutions;

import java.util.HashSet;
import java.util.Set;

public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] sides = new int[4][2];

        sides[0] = p1;
        sides[1] = p2;
        sides[2] = p3;
        sides[3] = p4;

        Set<Integer> sideLength = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                sideLength.add(getDistance(sides[i], sides[j]));
            }
        }
        return !sideLength.contains(0) && sideLength.size() == 2;
    }


    public int getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        System.out.printf("Result: %b\n", new ValidSquare().validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 12}));
    }
}
