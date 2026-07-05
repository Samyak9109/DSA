package TwoPointers;
//LINk -https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
//Link - https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicatesfromSortedArray {
        public int removeDuplicates(int[] nums) {

            // Edge case
            if(nums.length == 0) return 0;

            // i tracks location for next unique element
            int i = 0;

            // j scans array
            for(int j = 1; j < nums.length; j++) {

                // Found new unique element
                if(nums[j] != nums[i]) {

                    i++;

                    // place unique element
                    nums[i] = nums[j];
                }
            }

            // length of unique portion
            return i + 1;
        }

    public static int removeDuplicatesTwo(int[] nums) {

        // Edge case:
        // If array has 2 or fewer elements,
        // all are automatically valid.
        if (nums.length <= 2) {
            return nums.length;
        }

        /*
         * k represents the position where
         * next valid element should be placed.
         *
         * Start from index 2 because:
         * First two elements are always allowed.
         */
        int k = 2;

        /*
         * Start checking from 3rd element
         */
        for (int i = 2; i < nums.length; i++) {

            /*
             * Compare current element with
             * element at k-2.
             *
             * WHY?
             * Because if nums[i] == nums[k-2],
             * then this element would become
             * the THIRD duplicate.
             *
             * Example:
             * [1,1,1]
             *
             * k = 2
             * nums[i] = 1
             * nums[k-2] = nums[0] = 1
             *
             * So skip it.
             */

            if (nums[i] != nums[k - 2]) {

                /*
                 * Valid element found.
                 * Place it at k position.
                 */
                nums[k] = nums[i];

                /*
                 * Move k forward.
                 */
                k++;
            }
        }

        /*
         * k = new valid length
         */
        return k;
    }
}
