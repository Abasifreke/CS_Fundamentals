package Easy;

public class Sqrt {

    // 16
    // 8
    // 4

    // 81
    // 40
    // 20
    // 10
    // 5

    public static int sqrt(int num) {
        int lowerBound = num / 2;

        while (Math.pow(lowerBound, 2) > num) {
            System.out.println(lowerBound);
            lowerBound = lowerBound / 2;
        }

        while (Math.pow(lowerBound, 2) < num) {
            lowerBound += 1;
        }

        return lowerBound;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(4));
    }

}
