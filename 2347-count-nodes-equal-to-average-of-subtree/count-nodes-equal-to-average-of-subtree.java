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
import java.util.Map.Entry;

class Solution {
    public int averageOfSubtree(TreeNode root) {
        HashMap<TreeNode, int[]> nodeCountsAndSum = new HashMap<>();

        postOrder(root, nodeCountsAndSum);

        int counter = 0;
        for(Entry<TreeNode, int[]> entry: nodeCountsAndSum.entrySet()){

            if(entry.getKey().val == (entry.getValue()[1]/entry.getValue()[0])) counter++;
        }

        return counter++;
    }

    private int[] postOrder(TreeNode node, HashMap<TreeNode, int[]> nodeCountsAndSum){
        if(node == null) return new int[]{0, 0};

        if(nodeCountsAndSum.containsKey(node)) return nodeCountsAndSum.get(node);

        int[] left = postOrder(node.left, nodeCountsAndSum);
        int[] right = postOrder(node.right, nodeCountsAndSum);

        nodeCountsAndSum.put(node, new int[]{left[0] + right[0] + 1, left[1] + right[1] + node.val});
        return nodeCountsAndSum.get(node);
    }


}