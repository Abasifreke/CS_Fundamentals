package Blind75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

public class ProductOfAllButSelf {

    public int[] productExceptSelf(int[] nums) {

        // 1 2 0 3 4
        //
        // 1 2 6
        //

        // 24 12 4

        // 0 0 8 6
        int[] result = new int[nums.length];
        int indexOfZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // seen more than 1 zero
                if (indexOfZero != -1) {
                    return result;
                }
                indexOfZero = i;
            }
        }

        if (indexOfZero > -1) {
            int product = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    product *= nums[i];
                }
            }
            result[indexOfZero] = product;
            return result;
        }

        int[] prefix = new int[nums.length];
        prefix[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }


        for (int i = 0; i < nums.length; i++) {
            if (prefix[i] != 0 && suffix[i] != 0) {
                result[i] = prefix[i] * suffix[i];
            } else if (prefix[i] != 0) {
                result[i] = prefix[i];
            } else if (suffix[i] != 0) {
                result[i] = suffix[i];
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfAllButSelf pS = new ProductOfAllButSelf();

        pS.productExceptSelf(new int[] { -1, 1, 0, -3, 3 });
    }

}