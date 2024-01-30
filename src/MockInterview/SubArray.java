package MockInterview;
import java.util.ArrayList;
import java.util.List;

public class SubArray {

    public static void subarray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                List<Integer> sub = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    sub.add(arr[k]);
                }

                System.out.println(sub.toString());
            }
        }
    }

    public static void main(String[] args) {
        subarray(new int[] { 1, 2, 3, 4 });

    }
}
