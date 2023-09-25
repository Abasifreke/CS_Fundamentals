package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.LinkedList;

import Trees.TreeNode;

public class PreOrder {

    public static void preOrderIterative(TreeNode<Integer> node) {

        Stack<TreeNode<Integer>> s = new Stack<>();
        s.push(node);
        Set<TreeNode<Integer>> visited = new HashSet<>();
        System.out.println(node.getValue(node));
        visited.add(node);

        /*
         * 8
         * 4 10
         * 2 6 20
         * 20
         * 
         * 
         */
        // ]
        // 8, 4, 2, 6, 10, 20, 20,
        // (8),

        while (!s.isEmpty()) {
            TreeNode<Integer> curr = s.peek();

            if (curr.getLeft() != null && !visited.contains(curr.getLeft())) {
                s.push(curr.getLeft());
                System.out.println(curr.getLeft().getValue(curr.getLeft()));
                visited.add(curr.getLeft());
            } else if (curr.getRight() != null && !visited.contains(curr.getRight())) {
                s.push(curr.getRight());
                System.out.println(curr.getRight().getValue(curr.getRight()));
                visited.add(curr.getRight());
            }

            if (s.peek() == curr) {
                // visit
                curr = s.pop();
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

        preOrderIterative(root);
    }
}
