class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        // swap nums1 to be the smaller
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        Map<Integer, Integer> uniqueNums1 = new HashMap<>();
        for(int i: nums1){
            uniqueNums1.put(i, uniqueNums1.getOrDefault(i, 0) + 1);
        }
        
        ArrayList<Integer> union = new ArrayList<>();
        
        for(int i: nums2){
            if(uniqueNums1.getOrDefault(i, 0) > 0){
                union.add(i);
                uniqueNums1.put(i, uniqueNums1.get(i) -1);
            }
        }
        
        int[] result = new int[union.size()];
        
        int j = 0;
        for(int i: union){
            result[j++] = i;
        }
        return result;
        
    }
}