package MockInterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxDetonation {
    public static int maximumDetonation(int[][] bombs) {
        // create map of x|y to cord and radius
        Map<String, int[]> bombMap = new HashMap<>();

        for (int[] bomb : bombs) {
            bombMap.put(bomb[0] + "|" + bomb[1], bomb);
        }

        // get random point, run through map and check for neighbors.
        // DFS while increasing length and maybe updating max + updating map by removing
        // neighbors.
        // use absense of neighor in map to mean visited.
        int max = 0;
        for (String key : bombMap.keySet()) {
            int[] reach = { 1 };
            Set<String> visited = new HashSet<>();
            visited.add(key);
            checkMaxDetox(key, bombMap, reach, visited);
            System.out.println(reach[0]);
            max = Math.max(max, reach[0]);
        }

        return max;
    }

    private static void checkMaxDetox(String key, Map<String, int[]> bombMap, int[] reach, Set<String> visited) {
        // get key's unvisited neighbors
        int[] bomb = bombMap.get(key);
        for (String nKey : bombMap.keySet()) {
            int[] neighor = bombMap.get(nKey);

            System.out.println("vals " + bomb[0] + " " + neighor[0] + " " + bomb[1] + " " + neighor[1]);
            System.out.println("calcDistance " + key + " to " + nKey + " "
                    + (calcDistance(bomb[0], neighor[0], bomb[1], neighor[1])));
            if (!visited.contains(nKey) && calcDistance(bomb[0], neighor[0], bomb[1], neighor[1]) <= bomb[2]) {
                reach[0] = reach[0] + 1;
                visited.add(nKey);
                checkMaxDetox(nKey, bombMap, reach, visited);
            }
        }
    }

    public static double calcDistance(double x1, double y1, double x2, double y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;

        // Using the Pythagorean theorem to calculate the distance
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        return distance;
    }

    public static void main(String[] args) {
        int[][] bombs = { { 2, 1, 3 }, { 6, 1, 4 } };
        System.out.println(maximumDetonation(bombs));
    }
}