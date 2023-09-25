package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import Trees.TreeNode;

public class PostOrder {

    public static void postOrderIterative(TreeNode<Integer> node) {

        Stack<TreeNode<Integer>> s = new Stack<>();
        s.push(node);
        Set<TreeNode<Integer>> visited = new HashSet<>();
        visited.add(node);

        // [8, 10, 20, ]
        // 2, 6, 4, 20, 20, 10, 8
        while (!s.isEmpty()) {
            TreeNode<Integer> curr = s.peek();
            if (curr.getRight() != null && !visited.contains(curr.getRight())) {
                visited.add(curr.getRight());
                s.push(curr.getRight());
            }

            if (curr.getLeft() != null && !visited.contains(curr.getLeft())) {
                visited.add(curr.getLeft());
                s.push(curr.getLeft());
            }

            if (s.peek() == curr) {
                // visit
                curr = s.pop();
                System.out.println(curr.getValue(curr));
            }
        }
    }

    public static void main(String[] args) {
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

        /*
         * 8
         * 4 10
         * 2 6 20
         * 20
         * 
         * 
         */

        postOrderIterative(root);
    }
}
