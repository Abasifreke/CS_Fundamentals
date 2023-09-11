package Trees;

/**
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in
 * the tree.
 */
public class SmallestKElement {
    private static class NodeOrder {
        TreeNode n;
        int order;

        NodeOrder(TreeNode n, int order) {
            this.n = n;
            this.order = order;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        // implement inOrder transversal while keeping track of order and comparing
        // against k
        NodeOrder no = inOrder(new NodeOrder(root, 0), k);
        return no != null ? no.n.val : -1;
    }

    private NodeOrder inOrder(NodeOrder nodeOrder, int k) {
        if (nodeOrder.n == null || nodeOrder.order == k) {
            return nodeOrder;
        }

        // Traverse the left subtree
        NodeOrder leftResult = inOrder(new NodeOrder(nodeOrder.n.left, nodeOrder.order), k);

        // If we've found the k-th smallest in the left subtree, return it
        if (leftResult.order == k) {
            return leftResult;
        }

        // Visit the current node
        nodeOrder.order = leftResult.order + 1;
        if (nodeOrder.order == k) {
            return nodeOrder;
        }

        // Traverse the right subtree
        return inOrder(new NodeOrder(nodeOrder.n.right, nodeOrder.order), k);

    }
}
