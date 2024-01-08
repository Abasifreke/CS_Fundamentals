class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        for(int i = 0; i < nums1.length; i++){
            int num1Val = nums1[i];

            boolean foundNum1Val = false;
            for(int j = 0; j < nums2.length; j++){
                if(num1Val == nums2[j]){
                    foundNum1Val = true;
                }

                if(foundNum1Val && (nums2[j] > num1Val)){
                    res[i] = nums2[j];
                    break;
                }
            }
        }

    return res;
    }

}