class TimeMap {
    HashMap<String, ArrayList<Pair<Integer, String>>> keyTimeMap;
    
    public TimeMap() {
        keyTimeMap = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new ArrayList());
        }
        
        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }
        ArrayList<Pair<Integer, String>> values = keyTimeMap.get(key);
        
        if (timestamp < values.get(0).getKey()) {
            return "";
        }
        
        // Using binary search on the list of pairs.
        int left = 0;
        int right = values.size()-1;
        
        String answer = "";
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if(values.get(mid).getKey() == timestamp) return values.get(mid).getValue();

            if (values.get(mid).getKey() <= timestamp) {
                answer = values.get(mid).getValue(); //potential answer
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }

        // If iterator points to first element it means, no time <= timestamp exists.
        // if (right == 0) {
        //     return "";
        // }
                
        return answer;
    }
}