/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If this node is Empty, then no tree is rooted at this Node
        // Hence, "tree rooted at node" cannot be equal to "tree rooted at subRoot"
        // "tree rooted at subRoot" will always be non-empty, as per constraints
        if (root == null) {
            return false;
        }

        // Check if the "tree rooted at root" is identical to "tree roooted at subRoot"
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // If not, check for "tree rooted at root.left" and "tree rooted at root.right"
        // If either of them returns true, return true
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}