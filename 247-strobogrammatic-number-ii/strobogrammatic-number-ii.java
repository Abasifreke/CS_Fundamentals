class Solution {
    public List<String> findStrobogrammatic(int n) {
        /*
            0 -> 0
            1 -> 1
            8 -> 8

            6 -> 9
            9 -> 6
           

        for i from 0 -> 10^n
            
        */
        List<String> res = new ArrayList<>();
        int[] selfMappers = new int[]{0, 1, 8};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        map.put(6, 9);
        map.put(9, 6);

        if(n % 2 == 0){
            buildWord(map, "", n, res);
        }else{
            for(int i = 0; i < selfMappers.length; i++){
                buildWord(map, selfMappers[i] + "", n-1, res);
            } 
        }
       
        // [111, 609, 619, 689, 888, 906, 916, 986] : n =3
        // map, "0", 2, [] | 
        return res;
    }

    private void buildWord(Map<Integer, Integer> map, String accumulator, int n, List<String> res){
        if(n == 0){
            res.add(accumulator);
            return;
        }

        for(int key: map.keySet()){
            if(n == 2 && key == 0) continue;

            buildWord(map, key + accumulator + map.get(key), n - 2, res);
        }
    }
}