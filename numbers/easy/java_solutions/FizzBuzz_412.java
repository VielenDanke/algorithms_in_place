package numbers.easy.java_solutions;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {

    public List<String> fizzBuzz(int n) {
        var list = new ArrayList<String>();

        for (var i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
