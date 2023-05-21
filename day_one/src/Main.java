import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int nRow = 5;
//        printPascalTriangleViaIteration(nRow);
//        printPascalTriangleViaRecursion(nRow);
        printPascalTriangleViaMemoization(nRow);
    }

    private static void printPascalTriangleViaIteration(int nRow) {
        int[][] tri = new int[nRow][];

        for (int i = 0; i < nRow; i++) {
            tri[i] = new int[i + 1];      // Creating Individual rows

            for (int j = 1; j < i; j++) {
                tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j]; //
            }

            tri[i][0] = 1; // First element is always 1
            tri[i][i] = 1; // Last element is always 1

            // Printing the particular row
            for (int j = 0; j <= i; j++) {
                System.out.print(tri[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void printPascalTriangleViaRecursion(int nRow) {
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(printPascalValue(i,j) + " ");
            }
            System.out.println();
        }
    }

    private static int printPascalValue(int row, int col) {
        if (col == 0 || col == row) {
            return 1; // First and Last element is always 1
        }
        return printPascalValue(row - 1, col - 1) + printPascalValue(row - 1, col);
    }

    private static void printPascalTriangleViaMemoization(int nRow) {
        Map<String, Integer> cache = new HashMap<>();

        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(printPascalValueMemo(i,j,cache) + " ");
            }
            System.out.println();
        }
    }

    private static int printPascalValueMemo(int row, int col, Map<String, Integer> cache) {
        if (col == 0 || col == row) {
            return 1; // First and Last element is always 1
        }
        String key = Integer.toString(row)+ col;
        if (cache.containsKey(key)){ // Checking if the value is present in cache
            return cache.get(key);
        }
        int val = printPascalValueMemo(row - 1, col - 1, cache) + printPascalValueMemo(row - 1, col, cache);
        cache.put(key, val); // if value is not found we are saving the value
        return val;
    }
}
