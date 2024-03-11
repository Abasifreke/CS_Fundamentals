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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        height(root, result);
        return result;
    }

    private int height(TreeNode root, List<List<Integer>> result){
        if(root == null) return -1;

        int left = -1;
        int right = -1;
        if(root.left != null){
            left = height(root.left, result);
        }

        if(root.right != null){
            right = height(root.right, result);
        }

        int nodeHeight = 1 + Math.max(left, right);

        if(result.size() -1 < nodeHeight){
            result.add(new ArrayList<>());   
        }
        
        result.get(nodeHeight).add(root.val);
        return nodeHeight;
    }
}