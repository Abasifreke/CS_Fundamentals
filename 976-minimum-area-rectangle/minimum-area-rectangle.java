class Solution {
    private int getSize(int[][] points,int index) {
        Set<Integer> set = new HashSet<>();
        for(int[]point:points){
            set.add(point[index]);
        }
        return set.size();
    }
    private void generateMap(Map<Integer,List<Integer>> map, int[][]points, int index){
        for(int[]point:points){
            int key = point[index];
            int value = point[1-index];
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(value);
        }
    }
    public int minAreaRect(int[][] points) {
        int rowSize = getSize(points,0);
        int colSize = getSize(points,1);
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        if(rowSize > colSize) {
            generateMap(map,points,0);
        } else {
            generateMap(map,points,1);
        }
        Map<Pair<Integer,Integer>,Integer> lastIndex = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(Integer key: map.keySet()){
            List<Integer> list = map.get(key);
            Collections.sort(list);
            int currentY = key;
            for(int i=0;i<list.size();i++){
                 int x1 = list.get(i);
                for(int j=0;j<i;j++){           
                    int x2 = list.get(j);
                    Pair lastIndexKey = new Pair(x1,x2);
                    if(lastIndex.containsKey(lastIndexKey)){
                        min = Math.min(min, (currentY-lastIndex.get(lastIndexKey))*(x1-x2));
                    }
                    lastIndex.put(lastIndexKey,currentY);
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
        
    }
}