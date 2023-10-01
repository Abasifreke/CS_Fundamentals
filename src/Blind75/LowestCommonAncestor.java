package Blind75;

import java.util.HashMap;
import java.util.Map;

import Trees.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // keep map of parents.
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        getParents(root, parentMap);

        // trace depth of both nodes.
        int pDepth = 0, qDepth = 0;

        TreeNode curr = p;
        while (curr != null) {
            curr = parentMap.get(curr);
            pDepth++;
        }

        curr = q;
        while (curr != null) {
            curr = parentMap.get(curr);
            qDepth++;
        }

        // deeper to meet smaller
        while (pDepth > qDepth) {
            p = parentMap.get(p);
        }
        while (pDepth < qDepth) {
            q = parentMap.get(q);
        }

        while (p != q) {
            p = parentMap.get(p);
            q = parentMap.get(q);
        }

        return p;

    }

    public void getParents(TreeNode node, Map<TreeNode, TreeNode> pMap) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            pMap.put(node.left, node);
            getParents(node.left, pMap);
        }

        if (node.right != null) {
            pMap.put(node.right, node);
            getParents(node.right, pMap);
        }
    }

}