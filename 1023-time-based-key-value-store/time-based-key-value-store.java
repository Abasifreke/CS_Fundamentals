class TimeMap {

    Map<String, List<Pair<String, Integer>>> map = new HashMap<>();
    public TimeMap() { }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        return binaryGet(map.get(key), 0, map.get(key).size() - 1, timestamp);
    }
    
    private String binaryGet(List<Pair<String, Integer>> list, int start, int end, int timestamp) {
    
        if(start > end) return "";
        
        int mid = start + (end - start) / 2;
        Pair<String, Integer> midItem = list.get(mid);
        
        if(timestamp == midItem.getValue()) return midItem.getKey();
        
        if(timestamp < midItem.getValue()) {
            if(mid - 1 < 0) return "";
            if(list.get(mid - 1).getValue() <= timestamp) return list.get(mid - 1).getKey();
            return binaryGet(list, start, mid - 1, timestamp);
        }
        else {
            if(mid + 1 >= list.size()) return midItem.getKey();
            if(list.get(mid + 1).getValue() == timestamp) return list.get(mid + 1).getKey();
            return binaryGet(list, mid + 1, end, timestamp);
        }
    }
}