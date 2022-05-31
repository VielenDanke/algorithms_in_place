package strings.medium.java_solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckIfStringContainsAllBinaryCodesOfSizeK_1461 {

    public boolean hasAllCodes(String s, int k) {
        Set<String> binaries = new HashSet<>();
        for (int i = 0; i + k <= s.length(); i++) {
            binaries.add(s.substring(i, i + k));
        }
        return binaries.size() == 1 << k;
    }

    // -----------------------------------------------------------------
    // Backtracking - Time limit

    public boolean hasAllCodesTimeLimit(String s, int k) {
        if (k >= s.length()) {
            return false;
        }
        Map<String, Boolean> binaries = generateAllBinaries(k);
        for (int i = 0; i + k <= s.length(); i++) {
            String sub = s.substring(i, i + k);
            if (binaries.containsKey(sub)) {
                binaries.put(sub, true);
            }
        }
        for (Map.Entry<String, Boolean> entry : binaries.entrySet()) {
            if (!entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private Map<String, Boolean> generateAllBinaries(int k) {
        Map<String, Boolean> binaries = new HashMap<>();
        backtrackGenerator(binaries, "", k);
        return binaries;
    }

    private void backtrackGenerator(Map<String, Boolean> binaries, String temp, int k) {
        if (temp.length() == k) {
            binaries.put(temp, false);
            return;
        }
        for (int i = 0; i < k; i++) {
            backtrackGenerator(binaries, temp + "0", k);
            backtrackGenerator(binaries, temp + "1", k);
        }
    }
}
