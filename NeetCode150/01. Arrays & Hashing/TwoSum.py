class Solution(object):
    def twoSum(self, nums, target):
        # Dictionary to store:
        # Key   -> number
        # Value -> index of that number
        seen = {}

        # Traverse the array with both index and value
        for i, num in enumerate(nums):

            # Find the number needed to reach the target
            complement = target - num

            # If the complement has already been seen,
            # we found the required pair
            if complement in seen:
                # Return the index of the complement
                # and the current index
                return [seen[complement], i]

            # Store the current number and its index
            # so it can be used for future complements
            seen[num] = i

        # If no valid pair exists, return an empty list
        return []