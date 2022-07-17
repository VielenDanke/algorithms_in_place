package tree.easy.java_solutions;

public class FirstBadVersion_278 {

    private record Solution(int[] versions) {

        public int firstBadVersion(int n) {
            int left = 0, right = n;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (!isBadVersion(middle - 1) && isBadVersion(middle)) {
                    return middle;
                }
                if (isBadVersion(middle)) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            return -1;
        }

        private boolean isBadVersion(int idx) {
            return versions[idx] == -1;
        }
    }
}
