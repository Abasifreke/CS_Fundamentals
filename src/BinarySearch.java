import java.util.Arrays;

public class BinarySearch {

    /*
     * return index of search target in a sorted array. If not found, return -1;
     */
    public static int binarySearch(int[] arr, int target) {
        if (arr.length < 1) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        return binarySearch(arr, left, right, target);
    }

    private static int binarySearch(int[] arr, int start, int end, int target) {
        int middle = (start + end) / 2;
        int middleVal = arr[middle];

        if (middleVal == target) {
            return middle;
        }

        if (middleVal < target) {
            return binarySearch(arr, middle + 1, end, target);
        } else {
            return binarySearch(arr, start, middle - 1, target);
        }
    }

    /*
     * find min in rotated sorted array
     * that means finding the start of the array.
     * we find that by figuring out where rotation stopped
     */
    public static int findMin(int[] arr) {
        if (arr.length < 1) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        return binarySearchRotated(arr, left, right);

    }

    private static int binarySearchRotated(int[] arr, int left, int right) {
        int middle = (left + right) / 2;
        int middleVal = arr[middle];

        if (left == right) {
            return arr[left];
        }

        boolean isRotated = arr[left] > arr[right];
        // is left in order and is middle in between or is left greater than target
        if (isRotated && arr[left] < middleVal) {
            return binarySearchRotated(arr, middle + 1, right);
        }
        return binarySearchRotated(arr, left, middle);

    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 5, 6, 7, 20, -2, -1, 0 };

        System.out.println(findMin(input));
    }
}
