package Graphs;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Graph {

    public Node[] nodes;

    private class Node<T> {
        private T value;
        private Node<T>[] adjacent;
        private boolean visited;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        Node<Integer> n0 = graph.new Node(0);
        Node<Integer> n1 = graph.new Node(1);
        Node<Integer> n2 = graph.new Node(2);
        Node<Integer> n3 = graph.new Node(3);
        Node<Integer> n4 = graph.new Node(4);
        Node<Integer> n5 = graph.new Node(5);
        Node<Integer> n6 = graph.new Node(6);

        n0.adjacent = new Node[] { n1, n4, n5 };
        n1.adjacent = new Node[] { n3, n4 };
        n2.adjacent = new Node[] { n3 };
        n3.adjacent = new Node[] { n2, n4 };
        n4.adjacent = new Node[] {};
        n5.adjacent = new Node[] {};
        n6.adjacent = new Node[] {};

        graph.nodes = new Node[] { n0, n1, n2, n3, n4, n5, n6 };

        // graph.DFSOnGraph(graph);
        graph.BFSOnGraph(graph);
    }

    public void DFSOnGraph(Graph g) {
        for (Node<Integer> n : g.nodes) {
            DFS(n);
        }
    }

    private void DFS(Node<Integer> root) {
        if (!root.visited) {
            System.out.println(root.value + " ");
            root.visited = true;
        } else {
            return;
        }

        for (Node<Integer> n : root.adjacent) {
            DFS(n);
        }
    }

    public void BFSOnGraph(Graph g) {
        for (Node<Integer> n : g.nodes) {
            BFS(n);
        }
    }

    // mark it, enque it, while queue isn't empty, dequeue, print, add all unvisited
    // children and mark those too and so on.
    private void BFS(Node<Integer> n) {
        LinkedList<Node> dq = new LinkedList<>();

        if (!n.visited) {
            dq.add(n);
            n.visited = true;
        }

        while (!dq.isEmpty()) {
            Node<Integer> current = dq.poll();
            System.out.println(current.value);

            for (Node m : current.adjacent) {
                if (!m.visited) {
                    dq.add(m);
                    m.visited = true;
                }
            }
        }
    }
}
