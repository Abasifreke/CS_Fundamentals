class Solution {
    public int[] dailyTemperatures(int[] temp) {
        /*
        counter =       
        temperatures = [73,74,75,71,69,72,76,73]
        stack = [(76, 6), (73, 7)]
        output = [1, 1, 4, 2, 1 , 1 , 0 , 0]
        */

        int[] result = new int[temp.length];
        Stack<int[]> stack = new Stack<>(); // stack entry pair represents (temp val, index)

        for(int i = 0; i < temp.length; i++){
            int currTemp = temp[i];

            while(!stack.isEmpty() && stack.peek()[0] < currTemp){
                int[] prevTemp = stack.pop();
                result[prevTemp[1]] = i - prevTemp[1];
            }

            stack.push(new int[]{currTemp, i});
        }

        return result;

    }
}