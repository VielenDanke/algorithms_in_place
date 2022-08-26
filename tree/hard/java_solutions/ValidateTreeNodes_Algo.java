package tree.hard.java_solutions;

import static tree.Helper.BST;

public class ValidateTreeNodes_Algo {

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        // Write your code here.
        // nodeOne or nodeThree is an ancestor of nodeTwo
        // if nodeOne is an ancestor - check if nodeThree is a descendant of nodeTwo
        // if nodeThree is an ancestor - check if nodeOne is a descendant of nodeTwo
        BST candidateOne = findDirectAncestor(nodeOne, nodeTwo);
        if (candidateOne != null) {
            return findDirectAncestor(nodeTwo, nodeThree) != null;
        }
        BST candidateThree = findDirectAncestor(nodeThree, nodeTwo);
        if (candidateThree != null) {
            return findDirectAncestor(nodeTwo, nodeOne) != null;
        }
        return false;
    }

    private BST findDirectAncestor(BST candidate, BST node) {
        if (candidate == null) {
            return null;
        }
        if (candidate.left != null && candidate.left == node) {
            return candidate;
        }
        if (candidate.right != null && candidate.right == node) {
            return candidate;
        }
        BST left = findDirectAncestor(candidate.left, node);
        if (left != null) {
            return left;
        }
        return findDirectAncestor(candidate.right, node);
    }
}
