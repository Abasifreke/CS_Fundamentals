import java.util.Arrays;

public class MergeSort {
    
    public static int[] mergeSort(int[] arr){
        return mergeSort(arr, true);
    }
    // 4 1 | 3 |2 0
    private static int[] mergeSort(int[] arr, boolean shouldSplit){
        if(arr.length == 1){
            return arr;
        }
        
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid), shouldSplit);
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length), shouldSplit);

        return merge(left, right);
    }

    private static int[] merge(int[] arr1, int[] arr2){
        int leftL = arr1.length, rightL = arr2.length, i = 0, j = 0, l = 0;
        int[] result = new int[leftL + rightL];

        while(i < leftL  && j < rightL){
            if(arr1[i] < arr2[j]){
                result[l] = arr1[i];
                i++;
            }else{
                result[l] = arr2[j];
                j++;
            }
            l++;
        }

        while(i < leftL){
            result[l++] = arr1[i++];
        }

        while(j < rightL){
            result[l++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args){
        int[] input = {4, 1, 3, 2, 0};
        System.out.println(Arrays.toString(mergeSort(input)));
        
    }
}
