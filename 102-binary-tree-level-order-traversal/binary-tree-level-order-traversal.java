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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        inOrder(root, 0, result);
        return result;
    }

    private void inOrder(TreeNode root, int height, List<List<Integer>> result){
        
        if(root == null) return;

        if(result.size() <= height){
            List<Integer> row = new ArrayList<>();
            row.add(root.val);
            result.add(row);
        }else{
            result.get(height).add(root.val);
        }

        inOrder(root.left, height+ 1, result);
        inOrder(root.right, height+ 1, result);

    }
}