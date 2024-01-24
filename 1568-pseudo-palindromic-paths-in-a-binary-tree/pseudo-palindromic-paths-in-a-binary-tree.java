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
    public int pseudoPalindromicPaths (TreeNode root) {

        int[] numOfPalPaths = {0};
        int[] map = new int[10];
        
        travelToLeaf(root, map, numOfPalPaths);
        return numOfPalPaths[0];
    }

    private void travelToLeaf(TreeNode root, int[] map, int[] numOfPalPaths){
        map[root.val]++;
        
        if(root.left == null && root.right == null){
            int numOfOdds = 0;
            for(int nodeVal: map){
                if(nodeVal % 2 == 1){
                    numOfOdds++;
                }
            }

            if(numOfOdds <= 1){
                numOfPalPaths[0]++;
            }
        }
       
        if(root.left != null){
            travelToLeaf(root.left, map, numOfPalPaths);
        }

        if(root.right != null){
            travelToLeaf(root.right, map, numOfPalPaths);
        }

        map[root.val]--;
    }
}