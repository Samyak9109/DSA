package TwoPointers;

import java.util.HashMap;

//Leetcode link - https://leetcode.com/problems/two-sum/description/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        // Stores: value -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse array once
        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];

            // Number needed to reach target
            int complement = target - current;

            // Check if complement already exists
            if (map.containsKey(complement)) {

                // Return indices
                return new int[]{map.get(complement), i};
            }

            // Store current number and its index
            map.put(current, i);
        }

        return new int[]{-1, -1};
    }
}
