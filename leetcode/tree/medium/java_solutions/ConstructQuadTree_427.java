package leetcode.tree.medium.java_solutions;

import static leetcode.tree.Helper.QuadTreeNode;

public class ConstructQuadTree_427 {

    static class Solution {
        public QuadTreeNode construct(int[][] grid) {
            return recursion(grid, 0, 0, grid.length);
        }

        private QuadTreeNode recursion(int[][] grid, int x, int y, int len) {
            if (len == 1) {
                return new QuadTreeNode(grid[x][y] != 0, true, null, null, null, null);
            }
            QuadTreeNode result = new QuadTreeNode();

            QuadTreeNode topLeft = recursion(grid, x, y, len / 2);
            QuadTreeNode topRight = recursion(grid, x, y + len / 2, len / 2);
            QuadTreeNode bottomLeft = recursion(grid, x + len / 2, y, len / 2);
            QuadTreeNode bottomRight = recursion(grid, x + len / 2, y + len / 2, len / 2);

            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                    && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
                result.isLeaf = true;
                result.val = topLeft.val;
            } else {
                result.topLeft = topLeft;
                result.topRight = topRight;
                result.bottomLeft = bottomLeft;
                result.bottomRight = bottomRight;
            }
            return result;
        }
    }
}
