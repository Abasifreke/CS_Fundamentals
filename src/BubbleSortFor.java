public class BubbleSortFor {

    // Method to perform bubble sort on an array of integers
    public static void bubbleSort(int[] array) {
        // Outer loop performs multiple passes through the array
        for (int i = 0; i < array.length - 1; i++) {
            // Inner loop performs comparisons between adjacent elements
            for (int j = 0; j < array.length - i - 1; j++) {
                // If the current element is greater than the next element, they are swapped
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 3, 6, 1, 4, 2, 9, 7, 8, 5, 0 };
        array = new int[] { 6, 5, 4, 3, 2 };
        array = new int[] {1, 2, 3, 5, 6, 4};

        // Call the bubble sort method on the array
        bubbleSort(array);

        System.out.println("Sorted array:");
        // Print the sorted array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
