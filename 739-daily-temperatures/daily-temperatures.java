class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] result = new int[temp.length];
        int maxTemp = 0;

        for(int i = temp.length - 1; i >= 0; i--){
            int currTemp = temp[i];

            if(currTemp >= maxTemp){
                maxTemp = currTemp;
                continue;
            }

            int days = 1;

            while(temp[i + days] <= currTemp){
                days += result[i + days];
            }
            result[i] = days;
        }

        return result;
    }
}