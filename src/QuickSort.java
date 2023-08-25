import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 3, 4, 1, -2, 4, 8 };
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] array, int lowestIndex, int highestIndex) {

        if (lowestIndex >= highestIndex) {
            return;
        }

        int leftPointer = lowestIndex;
        int rightPointer = highestIndex;
        int pivot = array[highestIndex]; // could be random

        while (leftPointer < rightPointer) {

            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            // now you've found numbers that should swap sides
            int temp = array[leftPointer];
            array[leftPointer] = array[rightPointer];
            array[rightPointer] = temp;
        }

        // swap pivot at the end.
        int temp = array[leftPointer];
        array[leftPointer] = pivot;
        array[highestIndex] = temp;

        quickSort(array, lowestIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highestIndex);

    }
}
