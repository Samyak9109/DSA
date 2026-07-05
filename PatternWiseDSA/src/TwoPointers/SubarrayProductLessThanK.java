package TwoPointers;

// Link - https://leetcode.com/problems/subarray-product-less-than-k/
public class SubarrayProductLessThanK {

    /*
     Time Complexity: O(n)
     Reason:
     Each element enters and leaves the window at most once.

     Space Complexity: O(1)
     Reason:
     Only variables are used.
    */
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // Edge case:
        // No positive product can be smaller than 1 or 0
        if (k <= 1) {
            return 0;
        }

        // Left pointer of sliding window
        int left = 0;

        // Stores running product of current window
        int product = 1;

        // Final answer
        int count = 0;

        // Expand window using right pointer
        for (int right = 0; right < nums.length; right++) {

            // Include current element in product
            product *= nums[right];

            // Shrink window while condition breaks
            while (product >= k) {

                // Remove left element contribution
                product /= nums[left];

                // Move left pointer forward
                left++;
            }

            // Count valid subarrays ending at right
            count += (right - left + 1);
        }

        // Return total valid subarrays
        return count;
    }
}