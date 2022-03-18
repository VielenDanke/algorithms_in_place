package javasolutions.array.medium;

public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.printf("%b\n", increasingTriplet(new int[]{1,5,0,4,1,3}));
    }
}
