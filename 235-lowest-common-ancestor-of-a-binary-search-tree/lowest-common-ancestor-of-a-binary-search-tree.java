/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) return root;

        TreeNode leftCommonA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommonA = lowestCommonAncestor(root.right, p, q);

        if(leftCommonA != null && rightCommonA != null){
            return root;
        }  else if(leftCommonA == null){
            return rightCommonA;
        }else if(rightCommonA == null){
            return leftCommonA;
        }


        return null;
    }
}