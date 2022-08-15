import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {

    public static void main(String[] args) {
        System.out.println("Hello World");
        List<Integer> testList = new ArrayList<Integer>();
        testList.addAll(Arrays.asList(-3, 0, -1, 1, 1, 5, 4, 5, 2, 1, 8, 6, 1, 4, 2));
        System.out.println(dutchSort(testList, 5));
    }

    public static List<Integer> dutchSort(List<Integer> list, int pivot) {
        int right = list.size() - 1;
        // int pivotEnd = pivot;

        if (pivot > list.size() - 1 || list.size() <= 1) {
            return list;
        }

        int pivotValue = list.get(pivot);
        int i = 0;
        while (i <= right) {
            if (list.get(i) < pivotValue && i > pivot) {
                Collections.swap(list, i++, pivot++);
            } else if (list.get(i) > pivotValue) {
                Collections.swap(list, i, right--);
            } else {
                i++;
            }
        }
        return list;
    }
}
