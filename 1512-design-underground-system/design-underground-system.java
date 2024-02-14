class UndergroundSystem {
    private Map<Integer, Pair<String, Integer>> checkInMap; // { 32 -> (Par, 8),}
    private Map<String, Map<String, Pair<Double, Integer>>> graph; // {leyton -> {waterloo -> (11, 2)}}
    //  27 -> (leyton, 10) + [27,"Waterloo",20] = 10 
    public UndergroundSystem() {
        this.checkInMap = new HashMap();
        this.graph = new HashMap();   
    }
    
    public void checkIn(int id, String stationName, int t) {
        // update checkinmap
        this.checkInMap.put(id, new Pair<String, Integer>(stationName, t));
    }
    
    public void checkOut(int id, String checkOutStationName, int t) {
        // remove corr from checkInMap
        Pair<String, Integer> checkInStation = checkInMap.remove(id);
        String checkInStationName = checkInStation.getKey();
        int timeTaken = t - checkInStation.getValue();
        
        graph.putIfAbsent(checkInStationName, new HashMap<String, Pair<Double, Integer>>());
        graph.get(checkInStationName).putIfAbsent(checkOutStationName, new Pair<Double, Integer>(0.0, 0));
        Pair<Double, Integer> avgCount = graph.get(checkInStationName).get(checkOutStationName);
        Pair<Double, Integer> avgCountUpdated = new Pair<>(getCumuAvg(avgCount.getKey(), avgCount.getValue(), timeTaken),
                                                             avgCount.getValue()+1);                                                            
        graph.get(checkInStationName).put(checkOutStationName, avgCountUpdated);
    }

    private double getCumuAvg(double oldAvg, double oldCount, int newItem){
        return ((oldCount * oldAvg) + newItem)/(oldCount+1);
    }

    // assume valid inputs
    public double getAverageTime(String startStation, String endStation) {
        // read from graph
        return graph.get(startStation).get(endStation).getKey();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */