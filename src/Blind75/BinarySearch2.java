package Blind75;

public class BinarySearch2 {

    public int search(int[] nums, int target) {

        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        int middle = (start + end) / 2;
        int middleVal = nums[middle];

        if (start > end || start == end && middleVal != target) {
            return -1;
        }

        if (middleVal == target) {
            return middle;
        }

        int startVal = nums[start];

        if ((middleVal > startVal && target < middleVal && target >= startVal) ||
                (middleVal < startVal && (target < middleVal || target >= startVal))) {
            System.out.println("Went left");
            return search(nums, start, middle - 1, target);
        } else {
            System.out.println("Went right");
            return search(nums, middle + 1, end, target);
        }
    }

    private int searchIterative(int num[], int start, int end, int target) {
        while (start <= end) {
            int middle = (start + end) / 2;

            if (num[middle] == target) {
                return middle;
            } else if ((num[middle] > num[start] && target < num[middle] && target >= num[start])
                    || (num[middle] < num[start] && (target < num[middle] || target > num[start]))) {
                end = middle = 1;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }

}
