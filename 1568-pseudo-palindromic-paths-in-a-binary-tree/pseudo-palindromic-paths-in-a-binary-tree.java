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
        
        travelToLeaf(root, new HashMap<Integer, Integer>(), numOfPalPaths);
        return numOfPalPaths[0];
    }

    private void travelToLeaf(TreeNode root, HashMap<Integer, Integer> counter, int[] numOfPalPaths){
        if(root.left == null && root.right == null){
            counter.putIfAbsent(root.val, 0);
            counter.put(root.val, counter.get(root.val) + 1);
            int numOfOdds = 0;
            for(int nodeVal: counter.keySet()){
                if(counter.get(nodeVal) % 2 == 1){
                    numOfOdds++;

                    if(numOfOdds > 1)break;
                }
            }

            if(numOfOdds <= 1){
                numOfPalPaths[0]++;
            }

            // System.out.println(counter);
            // System.out.println("made numOfPalPaths = " + numOfPalPaths[0]);
            counter.put(root.val, counter.get(root.val) - 1);
        }
       
        if(root.left != null){
            counter.putIfAbsent(root.val, 0);
            counter.put(root.val, counter.get(root.val) + 1);
            travelToLeaf(root.left, counter, numOfPalPaths);
            counter.put(root.val, counter.get(root.val) - 1);
        }

        if(root.right != null){
            counter.putIfAbsent(root.val, 0);
            counter.put(root.val, counter.get(root.val) + 1);
            travelToLeaf(root.right, counter, numOfPalPaths);
            counter.put(root.val, counter.get(root.val) - 1);
        }
    }
}