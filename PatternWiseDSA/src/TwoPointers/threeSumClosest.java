package TwoPointers;

import java.util.Arrays;

public class threeSumClosest {

    /*
     * Time Complexity: O(n²)
     * Reason:
     * - Sorting takes O(n log n)
     * - Outer loop runs O(n) times
     * - Two pointers scan remaining array in O(n)
     * - Total complexity becomes O(n²)
     *
     * Space Complexity: O(1)
     * Reason:
     * - Only variables and pointers used
     * - No extra data structures created
     */

    public int threeSumClosest(int[] nums, int target) {

        // Sort array so two-pointer approach can work
        Arrays.sort(nums);

        // Initialize closest sum using first possible triplet
        int closest = nums[0] + nums[1] + nums[2];

        // Fix first element of triplet
        for (int i = 0; i < nums.length - 2; i++) {

            // Left pointer starts after fixed element
            int left = i + 1;

            // Right pointer starts at array end
            int right = nums.length - 1;

            while (left < right) {

                // Current triplet sum
                int sum = nums[i] + nums[left] + nums[right];

                // Update closest if current sum is nearer to target
                if (Math.abs(target - sum) <
                        Math.abs(target - closest)) {

                    closest = sum;
                }

                // Sum too small → increase total sum
                if (sum < target) {
                    left++;
                }

                // Sum too large → decrease total sum
                else if (sum > target) {
                    right--;
                }

                // Exact target found
                // Can't get closer than perfect match
                else {
                    return sum;
                }
            }
        }

        // Return best closest value found
        return closest;
    }

    public static void main(String[] args) {

        threeSumClosest obj = new threeSumClosest();

        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        System.out.println(
                obj.threeSumClosest(nums, target)
        );
    }
}