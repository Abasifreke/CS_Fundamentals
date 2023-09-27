package Easy;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MinDistInBST {

    public int getMinimumDifference(TreeNode root) {
        int[] minDiff = { Integer.MAX_VALUE }; // Declare minDiff as a local variable
        TreeNode prev = null;

        inOrderTraversal(root, prev, minDiff);
        return minDiff[0];
    }

    private void inOrderTraversal(TreeNode node, TreeNode prev, int[] minDiff) {
        if (node == null) {
            return;
        }

        // Recursively traverse the left subtree
        inOrderTraversal(node.left, prev, minDiff);

        // Calculate the difference with the previous node
        if (prev != null) {
            minDiff[0] = Math.min(minDiff[0], node.val - prev.val);
        }

        // Update the previous node
        prev = node;

        // Recursively traverse the right subtree
        inOrderTraversal(node.right, prev, minDiff);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        MinDistInBST solution = new MinDistInBST();
        int minDiff = solution.getMinimumDifference(root);
        System.out.println("Minimum Difference: " + minDiff);
    }
}
