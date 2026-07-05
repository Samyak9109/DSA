
//Leetcode link - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
package TwoPointers;

class TwoSum2 {

    /*
      Time Complexity: O(n)
      Reason:
      Each pointer moves at most n times.

      Space Complexity: O(1)
      Reason:
      No extra data structure used.
    */

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        // Keep moving pointers until they meet
        while (left < right) {

            // Calculate sum of actual elements
            int sum = numbers[left] + numbers[right];

            // Found target
            if (sum == target) {

                // Problem asks for 1-based indexing
                return new int[]{left + 1, right + 1};

            }

            // Sum too large → decrease right pointer
            else if (sum > target) {
                right--;
            }

            // Sum too small → increase left pointer
            else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }
}