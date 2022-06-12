package bit_manipulation.java_solutions;

public class BitwiseAND_201 {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int moveFactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}
