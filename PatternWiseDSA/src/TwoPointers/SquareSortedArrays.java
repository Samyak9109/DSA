package TwoPointers;

// Link - https://leetcode.com/problems/squares-of-a-sorted-array/description/
public class SquareSortedArrays {

    /*
     Time Complexity: O(n)
     Reason:
     We traverse the array only once using two pointers.

     Space Complexity: O(n)
     Reason:
     Extra result array is used to store sorted squares.
    */
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;

        // Result array to store final sorted squared values
        int[] res = new int[n];

        // Left pointer -> beginning of array
        int left = 0;

        // Right pointer -> end of array
        int right = n - 1;

        // Position to fill result array from back
        // Because largest squares come first
        int k = n - 1;

        // Continue until pointers cross each other
        while (left <= right) {

            // Calculate square of left element
            int leftSq = nums[left] * nums[left];

            // Calculate square of right element
            int rightSq = nums[right] * nums[right];

            // Compare both squares
            if (leftSq > rightSq) {

                // Larger square goes at current back position
                res[k--] = leftSq;

                // Move left pointer forward
                left++;

            } else {

                // Right square is larger or equal
                res[k--] = rightSq;

                // Move right pointer backward
                right--;
            }
        }

        // Return final sorted squares array
        return res;
    }

    /*
 Time Complexity: O(n)
 Reason:
 Each element is processed exactly once using two pointers.

 Space Complexity: O(n)
 Reason:
 Extra result array is used to store sorted squared values.
*/

    public int[] sortedSquaresMergeSortMethod(int[] nums) {

        // Length of input array
        int n = nums.length;

        // Result array to store final sorted squares
        int[] res = new int[n];

        // Pointer starting from beginning of array
        int left = 0;

        // Pointer starting from end of array
        int right = n - 1;

        // Index for filling result array from the back
        // Largest squares will be placed first
        int k = n - 1;

        // Continue until both pointers cross
        while (left <= right) {

            // Square value at left pointer
            int leftSq = nums[left] * nums[left];

            // Square value at right pointer
            int rightSq = nums[right] * nums[right];

            // Compare both squared values
            if (leftSq > rightSq) {

                // Left square is larger → place at current result position
                res[k--] = leftSq;

                // Move left pointer forward
                left++;

            } else {

                // Right square is larger or equal → place in result
                res[k--] = rightSq;

                // Move right pointer backward
                right--;
            }
        }

        // Return final sorted squares array
        return res;
    }
}