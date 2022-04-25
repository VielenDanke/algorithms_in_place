package numbers.easy.java_solutions;

public class Sqrt_69 {

    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        var left = 1;
        var right = 1 << 31;

        while (true) {
            var mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }

    public int mySqrtIterative(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        var prev = 1;
        for (int i = 2; i <= x; i++) {
            var current = i * i;
            if (current < x) {
                prev = i;
            } else if (current == x) {
                return i;
            } else {
                return prev;
            }
        }
        return prev;
    }
}
