package Blind75;

public class TrappingRain {
    public int trap(int[] height) {

        int left = 0;
        int right = 0;
        int volume = 0;

        for (int i = 1; i < height.length - 1; i++) {

            int maxFromLeft = 0;
            while (height[left] > height[i]) {
                maxFromLeft = Math.max(maxFromLeft, height[i]);
                if (i == height.length - 2) {
                    i += height[height.length - 1] > height[height.length - 2] ? 1 : 0;
                    maxFromLeft = Math.max(maxFromLeft, height[height.length - 1]);
                    break;
                } else {
                    i++;
                }
            }

            right = i;
            int minSide = Math.min(height[left], i == height.length - 1 ? maxFromLeft : height[right]);
            System.out.println(minSide);

            // volume
            for (int j = right - 1; j > left; j--) {
                volume += height[j] >= minSide ? 0 : minSide - height[j];
            }

            System.out.println("volume between " + left + " to " + right + " is " + volume);
            System.out.println(volume);

            i = right;
            left = right;
        }

        return volume;
    }

    public int trap3(int[] height) {

        int left = 0;
        int right = height.length -1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int volume = 0;

        
        while(left <= right){
            if(maxLeft <= maxRight){
                left++;
                volume += Math.max(0, maxLeft - height[left]);
                maxLeft = maxLeft <= height[left] ? height[left] : maxLeft;
            }else{
                right--;
                volume += Math.max(0, maxRight - height[right]);
                maxRight = maxRight <= height[right] ? height[right] : maxRight;
            }

            System.out.println(volume);
        }
        
        return volume;
    }


    public int trap2(int[] height) {
        
        int maxLindex = -1;
        int maxRindex = -1;
        int maxLeft = -1;
        int maxRight = -1;
        int min = -1;
        int volume = 0;

        for(int i = 0; i < height.length; i++ ){
            if(maxLeft == -1){
                maxLeft = height[i];
                maxLindex = i;
                continue;
            }

            if(maxLeft > -1 && min == -1){
                if(height[i] >= maxLeft){
                    maxLeft = height[i];
                    maxLindex = i;
                }else{
                    min = height[i];
                }
                continue;
            }

            if(maxLeft > -1 && min > -1 && maxRight == -1){
                if(height[i] < min){
                    min = height[i];
                    continue;
                }else{
                    maxRight = height[i];
                    maxRindex = i;
                    if(maxRight >= maxLeft){
                       // volume
                        for (int j = i; j > maxLindex; j--) {
                            volume += maxLeft - height[j];
                                        System.out.println("Volume :L " + volume);

                        }
                    }
                    continue;
                }
            }

            if(maxLeft > -1 && min > -1 && maxRight > -1){
                if(height[i] >= maxRight){
                    maxRight = height[i];
                    maxRindex = i;
                    continue;
                }else {
                    for (int j = maxRindex; j > maxLindex; j--) {
                            volume += maxRight - height[j];
                            System.out.println("maxRightIndex :R " + maxRindex);
                            System.out.println("Volume :R " + volume);

                        }

                        maxLeft = height[i];
                        maxLindex = i;
                        maxRindex = -1;
                        min = -1;
                        maxRight = -1;
                }
            }

            System.out.println("Volume " + volume);
        }
        return volume;
    }
}
