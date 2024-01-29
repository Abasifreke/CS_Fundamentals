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
    public boolean isBalanced(TreeNode root) {
        boolean[] isBal = new boolean[]{true};

       height(root, isBal);

       return isBal[0];
    }

    private int height(TreeNode node, boolean[] isBalanced){
        if(node == null){
            return 0;
        }

        int leftHeight = height(node.left, isBalanced);
        int rightHeight = height(node.right, isBalanced);
        isBalanced[0] = isBalanced[0] && Math.abs(leftHeight - rightHeight) < 2;

        int nodeHeight = Math.max(leftHeight, rightHeight) + 1;

        return nodeHeight;
    }
}