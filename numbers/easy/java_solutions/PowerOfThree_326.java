package numbers.easy.java_solutions;

public class PowerOfThree_326 {

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public boolean isPowerOfThreeMax(int n) {
        return n > 0 && Math.pow(3, 19) % n == 0;
    }
}
