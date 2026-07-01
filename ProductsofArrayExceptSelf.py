class Solution(object):
    def productExceptSelf(self, nums):
        """
        Approach:
        - First pass: store product of all elements to the left of each index.
        - Second pass: multiply it with product of all elements to the right.

        Time Complexity: O(n)
        Space Complexity: O(1)
        Note:
        - Output array is not counted as extra space.
        - No division is used.

        :type nums: List[int]
        :rtype: List[int]
        """

        n = len(nums)

        # result[i] will first store product of elements before i
        result = [1] * n

        # Prefix product
        prefix = 1
        for i in range(n):
            result[i] = prefix
            prefix *= nums[i]

        # Suffix product
        suffix = 1
        for i in range(n - 1, -1, -1):
            result[i] *= suffix
            suffix *= nums[i]

        return result