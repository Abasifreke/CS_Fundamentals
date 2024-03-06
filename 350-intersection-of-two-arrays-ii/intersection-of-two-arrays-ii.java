class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        // swap nums1 to be the smaller
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        Map<Integer, Integer> uniqueNums1 = Arrays.stream(nums1).boxed()
            .collect(Collectors.toMap(k -> k, v -> 1, (old, newer) -> old + newer));
        
        ArrayList<Integer> union = new ArrayList<>();
        
        Arrays.stream(nums2).forEach((i) -> {
            if(uniqueNums1.containsKey(i)){
                union.add(i);
                
                int val = uniqueNums1.get(i);
                if(val == 1){
                  uniqueNums1.remove(i);  
                }else{
                    uniqueNums1.put(i, val -1);
                }
            }
        });
        
        int[] result = new int[union.size()];
        
        int j = 0;
        for(int i: union){
            result[j++] = i;
        }
        
        return result;
        
    }
}