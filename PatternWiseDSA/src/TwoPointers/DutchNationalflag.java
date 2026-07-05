package TwoPointers;

public class DutchNationalflag {
    /*
     * Counting Approach (No Two Pointer)
     *
     * Time Complexity:
     * O(N) + O(N) = O(N)
     * Reason:
     * 1st pass -> count elements
     * 2nd pass -> rewrite array
     *
     * Space Complexity:
     * O(1)
     * Reason:
     * Only 3 integer variables used.
     */

    public static void sortColorsCount(int[] nums) {

        int zero = 0;
        int one = 0;
        int two = 0;

        // Count frequencies
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }

        int index = 0;

        // Fill 0s
        while (zero-- > 0) {
            nums[index++] = 0;
        }

        // Fill 1s
        while (one-- > 0) {
            nums[index++] = 1;
        }

        // Fill 2s
        while (two-- > 0) {
            nums[index++] = 2;
        }
    }

    /*
     * Dutch National Flag Algorithm / 3 Pointer Approach
     *
     * Time Complexity: O(N)
     * Reason:
     * Single traversal of the array.
     * Each element is processed at most once.
     *
     * Space Complexity: O(1)
     * Reason:
     * Uses only 3 pointers and a temp variable.
     */

    public static void sortColors2Pointer(int[] nums) {

        // low -> boundary for placing 0s
        int low = 0;

        // mid -> current element being processed
        int mid = 0;

        // high -> boundary for placing 2s
        int high = nums.length - 1;

        // Process array until mid crosses high
        while (mid <= high) {

            // Case 1: Current element is 0
            if (nums[mid] == 0) {

                // Swap current element with low position
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                // Move both pointers forward
                low++;
                mid++;
            }

            // Case 2: Current element is 1
            else if (nums[mid] == 1) {

                // 1 is already in correct middle region
                mid++;
            }

            // Case 3: Current element is 2
            else {

                // Swap current element with high position
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                // Reduce high boundary
                // Do NOT increment mid here
                // because swapped element must be checked again
                high--;
            }
        }
    }
}
