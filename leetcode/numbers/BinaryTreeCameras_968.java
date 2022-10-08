package leetcode.numbers;

import static leetcode.tree.Helper.TreeNode;

public class BinaryTreeCameras_968 {

    int numOfCameras = 0;

    //-1:Not monitored
    //0:monitored
    //1:has camera
    public int minCameraCover(TreeNode root) {
        return helper(root) == -1 ? numOfCameras + 1 : numOfCameras;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        //left or right leetcode.tree is not monitored
        //so we have to add camera here, to monitor itself and the unmonitored child
        //if some child has camera, then this root is monitored
        if (left == -1 || right == -1) {
            numOfCameras++;
            return 1;
        } else if (left == 1 || right == 1) {
            return 0;
        }
        return -1;
    }
}
