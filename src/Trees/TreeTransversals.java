package Trees;

public class TreeTransversals<V> {

    public void visit(TreeNode<V> node) {
        System.out.println(node.getValue(node));
    }

    public void inOrder(TreeNode<V> node) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeft());
        visit(node);
        inOrder(node.getRight());
    }

    public void preOrder(TreeNode<V> node) {
        if (node != null) {
            visit(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void postOrder(TreeNode<V> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            visit(node);
        }
    }

    /**
     * 
     * TESTER
     * 
     */
    public static void main(String args[]) {
        TreeNode<Integer> root = new TreeNode<>(8);
        TreeNode<Integer> four = new TreeNode<>(4);
        TreeNode<Integer> two = new TreeNode<>(2);
        TreeNode<Integer> six = new TreeNode<>(6);
        TreeNode<Integer> ten = new TreeNode<>(10);
        TreeNode<Integer> twenty = new TreeNode<>(20);
        TreeNode<Integer> twentyc = new TreeNode<>(20);

        root.setLeft(four);
        root.setRight(ten);
        four.setLeft(two);
        four.setRight(six);
        ten.setRight(twenty);
        twenty.setRight(twentyc);

        TreeTransversals<Integer> tts = new TreeTransversals<>();

        System.out.println("InOrder: ");
        tts.inOrder(root);
        System.out.println("PreOrder: ");
        tts.preOrder(root);
        System.out.println("PostOrder: ");
        tts.postOrder(root);

    }

}
