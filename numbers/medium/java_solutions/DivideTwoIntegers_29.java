package numbers.medium.java_solutions;

public class DivideTwoIntegers_29 {

    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        int a = Math.abs(dividend), b = Math.abs(divisor), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
}
