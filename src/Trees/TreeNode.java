package Trees;

public class TreeNode<T> {

    private T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    public T getValue(TreeNode<T> t) {
        if (t != null) {
            return t.value;
        }
        return null;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public TreeNode<T> getLeft() {
        return this.left;
    }

    public TreeNode<T> getRight() {
        return this.right;
    }
}
