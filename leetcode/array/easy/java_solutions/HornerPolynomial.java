package leetcode.array.easy.java_solutions;

public class HornerPolynomial {

    public int hornerPolynomial(int[] poly, int n, int x) {
        var result = poly[0];

        for (int i = 1; i < n; i++) {
            result = result * x + poly[i];
        }
        return result;
    }
}
