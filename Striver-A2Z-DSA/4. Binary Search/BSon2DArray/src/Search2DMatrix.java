import java.util.*;

public class Search2DMatrix {

    /*
     * 💡 Problem Summary:
     * Given a 2D matrix where each row is sorted in ascending order and the entire
     * matrix is treated as row-major sorted, find if a target exists.
     * Return true if found, false otherwise.
     *
     * 📚 LeetCode Equivalent: 74. Search a 2D Matrix
     * 📚 GFG Equivalent: Search in a row-wise and column-wise sorted matrix
     */

    // ======================================================
    // 🧱 BRUTE FORCE APPROACH
    // ======================================================
    // 🔹 Approach:
    //   - Traverse every element in the matrix one by one.
    //   - Compare with the target. If found, return true.
    //   - Else, continue until all elements are checked.
    //
    // 🔹 Time Complexity: O(n * m) → check each element
    // 🔹 Space Complexity: O(1) → no extra space
    static boolean searchMatrix_Brute(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    // ======================================================
    // ⚡ BETTER APPROACH — Binary Search on each row
    // ======================================================
    // 🔹 Approach:
    //   - Since each row is sorted, we can do a binary search on each row.
    //   - If target is found in any row, return true.
    //
    // 🔹 Time Complexity: O(n * log m) → n rows, binary search on m columns
    // 🔹 Space Complexity: O(1) → constant extra space
    static boolean searchMatrix_Better(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            int low = 0, high = m - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (matrix[i][mid] == target) return true;
                else if (matrix[i][mid] < target) low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }

    // ======================================================
    // 🚀 OPTIMAL APPROACH — 1D Mapping / Full Binary Search
    // ======================================================
    // 🔹 Approach:
    //   - Treat the 2D matrix as a 1D sorted array (row-major order).
    //   - Use a standard binary search with index mapping:
    //       row = mid / m
    //       col = mid % m
    //   - Prevent integer overflow with: mid = low + (high - low)/2
    //
    // 🔹 Time Complexity: O(log(n*m)) → log of total elements
    // 🔹 Space Complexity: O(1) → no extra space
    static boolean searchMatrix_Optimal(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        long low = 0, high = (long)n * m - 1; // use long for huge matrices

        while (low <= high) {
            long mid = low + (high - low) / 2;
            int row = (int)(mid / m);
            int col = (int)(mid % m);

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    // ======================================================
    // 🧠 MAIN METHOD — Testing all approaches
    // ======================================================
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;

        System.out.println("🔹 Brute Force → " + searchMatrix_Brute(matrix, target));
        System.out.println("🔹 Binary Search Row-wise → " + searchMatrix_Better(matrix, target));
        System.out.println("🔹 Optimal 1D Binary Search → " + searchMatrix_Optimal(matrix, target));
    }
}
