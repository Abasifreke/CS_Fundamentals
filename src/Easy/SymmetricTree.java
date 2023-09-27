package Easy;

import Trees.TreeNode;

public class SymmetricTree {

    public static boolean isSymmetric(TreeNode<Integer> root) {
        return isSymmetric(root, root);
    }

    private static boolean isSymmetric(TreeNode<Integer> left, TreeNode<Integer> right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            return false;
        } else if (right == null && left != null) {
            return false;
        }

        return left.getValue(left) == right.getValue(right)
                && isSymmetric(left.getLeft(), right.getRight())
                && isSymmetric(left.getRight(), right.getLeft());
    }

    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> twoL = new TreeNode<>(2);
        TreeNode<Integer> threeL = new TreeNode<>(3);
        TreeNode<Integer> fourL = new TreeNode<>(4);
        TreeNode<Integer> twoR = new TreeNode<>(2);
        TreeNode<Integer> threeR = new TreeNode<>(3);
        TreeNode<Integer> fourR = new TreeNode<>(4);

        root.setLeft(twoL);
        root.setRight(twoR);
        twoL.setLeft(threeL);
        twoL.setRight(fourL);
        twoR.setLeft(threeR);
        twoR.setRight(fourR);

        System.out.println(isSymmetric(root));
    }
}
