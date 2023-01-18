import java.util.HashSet;
import java.util.LinkedList;

public class TreesAndGraphs {

    private static class Node {

        private Node left;
        private Node right;

        private Node(int _value) {
        }
    }

    private static class GraphNode {
        private HashSet<GraphNode> adjacent = new HashSet<>();
        private STATE state;

        private GraphNode(int _value) {
        }

        private void addAdjacent(GraphNode node) {
            adjacent.add(node);
        }
    }

    private static class Graph {
        private HashSet<GraphNode> nodes;

        private Graph(HashSet<GraphNode> _nodes) {
            nodes = _nodes;
        }
    }

    /**
     * Implement a function to check that a binary tree is balanced.
     * A balanced binary tree is defined as one in which the heights of the 2
     * subtrees of any node
     * never differs by more than one.
     */
    public static boolean isBalanced(Node root) {
        if (root == null)
            return true;

        /*
         * E.g.
         * 
         * 7
         * 4 8
         * 2 3 9
         * 1
         * 
         * 
         */
        return checkHeight(root) != -1;
    }

    // this return a node's height if its subtrees' heights differ less than 2. else
    // it returns -1 to signify it's not balanced
    private static int checkHeight(Node node) {
        if (node == null)
            return 0;

        // TODO: can optimize to make this checkleft/right recursive call once.
        if (checkHeight(node.left) == -1 || checkHeight(node.right) == -1)
            return -1;
        int delta = Math.abs(checkHeight(node.left) - checkHeight(node.right));
        if (delta > 1)
            return -1;

        // return height
        return Math.max(checkHeight(node.left), checkHeight(node.right)) + 1;
    }

    public enum STATE {
        UNVISITED,
        VISITING,
        VISITED
    }

    /**
     * given a directed graph, design an algorithm to return if there's a path
     * between two nodes
     *
     * @param graph
     */
    private static boolean isJoined(Graph graph, GraphNode a, GraphNode b) {

        // set all nodes visited state to unvisited
        for (GraphNode g : graph.nodes) {
            g.state = STATE.UNVISITED;
        }

        LinkedList<GraphNode> q = new LinkedList<>();
        q.add(a);

        while (!q.isEmpty()) {
            GraphNode curr = q.poll();
            curr.state = STATE.VISITING;
            if (curr == b)
                return true;
            for (GraphNode graphNode : curr.adjacent) {
                if (graphNode.state == STATE.UNVISITED) {
                    q.add(graphNode);
                }
            }
            curr.state = STATE.VISITED;
        }
        return false;
    }

    public static void main(String[] args) {

        Node a = new Node(7);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(1);
        Node e = new Node(3);
        Node f = new Node(8);
        Node g = new Node(9);
        Node h = new Node(9);

        a.left = b;
        b.left = c;
        c.left = d;
        b.right = e;
        a.right = f;
        f.right = g;
        d.right = h;

        System.out.println(isBalanced(a));

        // testing graphs
        GraphNode r = new GraphNode(7);
        GraphNode s = new GraphNode(4);
        GraphNode t = new GraphNode(2);
        GraphNode u = new GraphNode(1);
        GraphNode v = new GraphNode(3);
        GraphNode w = new GraphNode(8);
        GraphNode x = new GraphNode(9);
        GraphNode y = new GraphNode(20);
        GraphNode z = new GraphNode(14);

        r.addAdjacent(s);
        r.addAdjacent(t);
        r.addAdjacent(y);
        r.addAdjacent(z);
        t.addAdjacent(s);
        t.addAdjacent(u);
        t.addAdjacent(r);
        t.addAdjacent(z);
        u.addAdjacent(w);
        u.addAdjacent(v);
        u.addAdjacent(z);
        x.addAdjacent(y);
        x.addAdjacent(r);
        x.addAdjacent(s);
        x.addAdjacent(z);
        z.addAdjacent(u);
        z.addAdjacent(v);
        z.addAdjacent(y);
        z.addAdjacent(w);

        HashSet<GraphNode> graphSet = new HashSet<>();
        graphSet.add(r);
        graphSet.add(s);
        graphSet.add(t);
        graphSet.add(u);
        graphSet.add(v);
        graphSet.add(w);
        graphSet.add(x);
        graphSet.add(y);
        graphSet.add(z);
        Graph graph = new Graph(graphSet);

        System.out.println(isJoined(graph, x, v));

    }

}
