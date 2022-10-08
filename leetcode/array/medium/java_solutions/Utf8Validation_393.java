package leetcode.array.medium.java_solutions;

public class Utf8Validation_393 {

    static class Solution {
        public boolean validUtf8(int[] data) {
            int bytesRemaining = 0;
            for (int d : data) {
                if (bytesRemaining == 0) {
                    if ((d >> 5) == 0b110) bytesRemaining = 1;
                    else if ((d >> 4) == 0b1110) bytesRemaining = 2;
                    else if ((d >> 3) == 0b11110) bytesRemaining = 3;
                    else if ((d >> 7) != 0) return false;
                } else {
                    if ((d >> 6) != 0b10) return false;
                    bytesRemaining--;
                }
            }
            return bytesRemaining == 0;
        }
    }

    static class SolutionWithBits {
        public boolean validUtf8(int[] data) {
            int count = 0;

            for (int current : data) {
                if (current >= 128 && current <= 191) {
                    if (count-- == 0) {
                        return false;
                    }
                } else {
                    if (count > 0) {
                        return false;
                    }
                    if (current < 128) {
                        continue;
                    } else if (current < 224) {
                        count = 1;
                    } else if (current < 240) {
                        count = 2;
                    } else if (current < 248) {
                        count = 3;
                    } else {
                        return false;
                    }
                }
            }
            return count == 0;
        }
    }
}
