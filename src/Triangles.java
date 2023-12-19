public class Triangles {

    public static void main(String[] args) {
        printTriangle(4, 4);
    }

    private static void printTriangle(int row, int col) {
        if (row == 0 || col == 0) {
            return;
        }

        System.out.print("* ");

        if (col == 1) {
            System.out.print("\n");
            printTriangle(row - 1, row - 1);
        } else {
            printTriangle(row, col - 1);
        }
    }
}
