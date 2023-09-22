package Blind75;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstras {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {

        Map<Integer, List<List<Integer>>> vertexMap = new HashMap<>();
        Map<Integer, Integer> nodeDistance = new HashMap<>();

        for (List<Integer> edge : edges) {
            if (!vertexMap.containsKey(edge.get(0))) {
                List<List<Integer>> neighbors = new ArrayList<>();
                neighbors.add(edge);
                vertexMap.put(edge.get(0), neighbors);
            } else {
                vertexMap.get(edge.get(0)).add(edge);
            }
        }

        System.out.println("Vertex Map");
        System.out.println(vertexMap);

        LinkedList<Integer> q = new LinkedList<>();

        q.add(src);
        nodeDistance.put(src, 0);

        while (!q.isEmpty()) {
            int current = q.poll();
            int distanceToCurr = nodeDistance.get(current);

            if (vertexMap.containsKey(current)) {
                vertexMap.get(current).sort(Comparator.comparingInt(a -> a.get(2)));
                for (List<Integer> edge : vertexMap.get(current)) {
                    if (!nodeDistance.containsKey(edge.get(1))) {
                        q.add(edge.get(1));
                        nodeDistance.put(edge.get(1), edge.get(2) + distanceToCurr);
                        System.out.println("Original " + edge.get(1) + " " + edge.get(2) + " " + distanceToCurr + " " +
                                nodeDistance.get(edge.get(1)));
                    } else {
                        System.out.println("Updating " + edge.get(1) + " " + edge.get(2) + " " + distanceToCurr + " " +
                                nodeDistance.get(edge.get(1)));
                        nodeDistance.put(edge.get(1), Math.min(edge.get(2) + distanceToCurr,
                                nodeDistance.get(edge.get(1))));

                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!nodeDistance.containsKey(i)) {
                nodeDistance.put(i, -1);
            }
        }

        return nodeDistance;
    }

    public static void main(String[] args) {
        Dijkstras ds = new Dijkstras();
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        // [0,1,10],[0,2,3],[1,3,2],[2,1,4],[2,3,8],[2,4,2],[3,4,5]
        List<Integer> edge0_1 = new ArrayList<>();
        List<Integer> edge0_2 = new ArrayList<>();
        List<Integer> edge1_3 = new ArrayList<>();
        List<Integer> edge2_1 = new ArrayList<>();
        List<Integer> edge2_3 = new ArrayList<>();
        List<Integer> edge2_4 = new ArrayList<>();
        List<Integer> edge3_4 = new ArrayList<>();

        edge0_1.add(0);
        edge0_1.add(1);
        edge0_1.add(10);

        edge0_2.add(0);
        edge0_2.add(2);
        edge0_2.add(3);

        edge1_3.add(1);
        edge1_3.add(3);
        edge1_3.add(2);

        edge2_1.add(2);
        edge2_1.add(1);
        edge2_1.add(4);

        edge2_3.add(2);
        edge2_3.add(3);
        edge2_3.add(8);

        edge2_4.add(2);
        edge2_4.add(4);
        edge2_4.add(2);

        edge3_4.add(3);
        edge3_4.add(4);
        edge3_4.add(5);

        edges.add(edge0_1);
        edges.add(edge0_2);
        edges.add(edge1_3);
        edges.add(edge2_1);
        edges.add(edge2_3);
        edges.add(edge2_4);
        edges.add(edge3_4);

        System.out.println(ds.shortestPath(5, edges, 0));
    }
}
