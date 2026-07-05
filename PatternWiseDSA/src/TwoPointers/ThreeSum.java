package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /*
     * Time Complexity: O(n²)
     * Reason:
     * - Sorting takes O(n log n)
     * - Outer loop runs O(n) times
     * - Two pointers together scan array in O(n)
     * - Overall: O(n²)
     *
     * Space Complexity: O(1) extra space
     * Reason:
     * - Only pointers used.
     * - Result list not counted in auxiliary space.
     */

    public List<List<Integer>> threeSum(int[] nums) {

        // Sort array so we can apply two-pointer technique
        Arrays.sort(nums);

        // Stores all valid unique triplets
        List<List<Integer>> result = new ArrayList<>();

        // Fix first element of triplet
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            // Prevents duplicate triplets in output
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Two pointers for remaining part of array
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                // Calculate current triplet sum
                int sum = nums[i] + nums[left] + nums[right];

                // Found valid triplet
                if (sum == 0) {

                    // Add triplet to result list
                    result.add(Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]
                    ));

                    // Skip duplicate values from left side
                    while (left < right &&
                            nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicate values from right side
                    while (left < right &&
                            nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers after finding answer
                    left++;
                    right--;

                }

                // Sum too small → need larger value
                else if (sum < 0) {
                    left++;
                }

                // Sum too large → need smaller value
                else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        ThreeSum obj = new ThreeSum();

        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(obj.threeSum(nums));
    }
}