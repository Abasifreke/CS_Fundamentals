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
    public int averageOfSubtree(TreeNode root) {
        int[] counter = {0};
        postOrder(root, counter);
        return counter[0];
    }

    private int[] postOrder(TreeNode node, int[] counter){
        if(node == null) return new int[]{0, 0};


        int[] left = postOrder(node.left, counter);
        int[] right = postOrder(node.right, counter);

        int count = left[0] + right[0] + 1;
        int sum = left[1] + right[1] + node.val;
        int[] result = new int[]{count, sum};

        if(node.val == sum/count) counter[0]++;

        return result;
    }


}