class Solution {
    public int minimumRounds(int[] tasks) {

        int n = tasks.length;
        Arrays.sort(tasks);
        // [2,2,2,3,3,4,4,4,4,4]
        //                       i 
        // sliding window to find length of similar numbers
        int minRounds = 0;
        int window = 1;
        for(int i = 1; i < n; i++){
            if(tasks[i] == tasks[i-1]){
                window++;
            }else {
                // solve for previous window length 
                if(window == 1) return -1;                
                minRounds += greedyLength(window);
                // reset window size
                window = 1;
            }
        }

        if(window == 1) return -1;                
        minRounds += greedyLength(window);

        return minRounds;

    }

    private int greedyLength(int length){
    
        if(length % 3 == 0) return length/3;

       
        int maxNumOf3 = 0;

        for(int i = 1; i <= length/3; i++){
            if((length - (i * 3)) % 2 == 0) {
                maxNumOf3 = Math.max(maxNumOf3, i);
            }
        }

        //  | | | - | | | -  | |  
        return maxNumOf3 + (length - (maxNumOf3*3))/2;
    }

}


        
     /*
     2,2,2,2,2,2,3,3
     6, 2

     10 <- 3, 3, 2, 2

    Say, X is number of occurence of a certain difficulty.
    rewrite tasks array as a list of x instead. and see if we can break those xs by 3 or 2
    if x is a factor of 3, we found ansewr. 
        just return x/3,

    if x is a factor 2
        int maxNumOf3 = 0;
        for(int i = 0; i <= x/3, i++){
            if([x - (i*3)] %2){
                maxNumOf3 = i;
            }
        }

 
        return maxNumOf3 + ([x - (maxNumOf3*3)]/2)

    totalMinRounds += 


    if x not a factor of 3 but of 2. 
        check if [x - (3 * (x/3))] % 2


      min = Int.max;   
        [2,2,2,2,2,2,3,3], r(tasks, i, acc)
             i  
           - r(tasks, 0, 0)
            if valid 2 step
            - r(task, i + 2, acc + 1)

            if valid 3 step
            - r(task, i + 3, acc + 1);

            

        if(i == n where n == tasks.length){
            min = math.min(min, acc);
        }

        */