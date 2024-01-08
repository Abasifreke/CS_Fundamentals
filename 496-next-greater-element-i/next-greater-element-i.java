class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> monoStack = new Stack<>();
        Map<Integer, Integer> greaterMap = new HashMap<>();

        for(int i = 0; i < nums2.length; i++){
            int num2Val = nums2[i];
            
            while(!monoStack.isEmpty() && monoStack.peek() < num2Val){
                greaterMap.put(monoStack.pop(), num2Val);
            }

            monoStack.push(num2Val);
        }

        while(!monoStack.isEmpty()){
            greaterMap.put(monoStack.pop(), -1);
        }

        for(int j = 0; j < nums1.length; j++){
            res[j] = greaterMap.get(nums1[j]);
        }


    return res;
    }

}