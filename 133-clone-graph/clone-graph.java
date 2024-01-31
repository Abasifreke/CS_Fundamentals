/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return DFS(node, new HashMap<Node, Node>());
    }

    private Node DFS(Node node, HashMap<Node, Node> visited){
        if(node == null){
            return null;
        }

        if(visited.containsKey(node)){
            return visited.get(node);
        }else{
            Node nodeCopy = new Node(node.val);
            visited.put(node, nodeCopy);

            for(Node child: node.neighbors){
                if(nodeCopy != null){
                    nodeCopy.neighbors.add(DFS(child, visited));
                }
            }

            
            return nodeCopy;
        }

    }
}