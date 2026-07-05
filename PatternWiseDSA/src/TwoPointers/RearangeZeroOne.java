package TwoPointers;
//Link - https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1

import java.util.Arrays;

public class RearangeZeroOne {

    /*
    Time Complexity: O(n)
    Reason: Each pointer moves at most n times.

    Space Complexity: O(1)
    Reason: Sorting done in-place, no extra array used.
    */
    public void segregate0and1(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            // Move low until we find a misplaced 1
            while (low < high && arr[low] == 0) {
                low++;
            }

            // Move high until we find a misplaced 0
            while (low < high && arr[high] == 1) {
                high--;
            }

            // Swap misplaced values
            if (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;

                low++;
                high--;
            }
        }
    }

    public static void main(String[] args) {

        RearangeZeroOne obj = new RearangeZeroOne();

        int[] arr = {1, 0, 1, 0, 1, 0, 0, 1};

        obj.segregate0and1(arr);

        System.out.println(Arrays.toString(arr));
    }
}