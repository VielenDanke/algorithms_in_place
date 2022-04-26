package numbers.easy.java_solutions;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            var nextNumber = 0;
            set.add(n);

            while (n != 0) {
                var rightNumber = n % 10;
                nextNumber += rightNumber * rightNumber;
                n /= 10;
            }
            if (set.contains(nextNumber)) {
                return false;
            }
            n = nextNumber;
        }
        return true;
    }
}
